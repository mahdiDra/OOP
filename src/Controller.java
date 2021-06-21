import java.util.ArrayList;
import java.util.Locale;

public class Controller {

    private ArrayList<Domestic> domestics;
    private ArrayList<Wild> wilds;
    private ArrayList<HelperAnimal> helperAnimals;
    private ArrayList<Factory> factories;
    private ArrayList<Production> productions;

    private Ground ground;
    private Well well;
    private Truck truck;
    private Mission mission;
    private int currentTime;
    private int money = 0;
    private boolean startCage,truckGO;

    public Controller(Mission mission)
    {
        this.mission = mission;
        this.wilds = new ArrayList<>();
        this.domestics = new ArrayList<>();
        this.helperAnimals = new ArrayList<>();
        this.ground = new Ground();
        this.factories = new ArrayList<>();
        this.truck = new Truck();
        this.well = new Well();
        this.productions = new ArrayList<>();
        this.currentTime = 0;
    }

    public String buyDomestic(String name)
    {
        Domestic newD = new Domestic(name.toLowerCase(Locale.ROOT));
        if(money >= newD.getPrice()){
            domestics.add(newD);
            money -= newD.getPrice();
            return "successful";
        }else
            return "not enough money!";
    }
    public String pickup(String x , String y)
    {
        Keys a = ground.getOut(Integer.parseInt(x),Integer.parseInt(y));
        if( a != null){
            switch (a) {
                case EGG, MILK, FEATHER, FLOUR, POCKET_MILK, CLOTH, BREAD, ICE_CREAM, DRESS -> {
                    productions.add(new Production(a.toString().toLowerCase(Locale.ROOT)));
                    ground.setProOff(Integer.parseInt(x),Integer.parseInt(y));
                }
                case BEAR, LION, TIGER -> {
                    wilds.add(new Wild(a.toString().toLowerCase(Locale.ROOT)));
                    ground.setProOff(Integer.parseInt(x),Integer.parseInt(y));
                }
            }
            return "successful";
        }else
            return "nothing to pickup!";
    }

    public String plant(String x , String y){
        if(well.getWater() == 0)
            return "empty bucket";
        well.decreaseSpace();
        ground.setOnPlant(Integer.parseInt(x),Integer.parseInt(y));
        return "successful";
    }
    public String work(String name){
        Production pro;
        for (Factory factory : factories) {
            if (name.equalsIgnoreCase(factory.getName())){
                switch (factory.getNeeds()){
                    case EGG:
                        if((pro = getEgg()) != null){
                            productions.remove(pro);
                            factory.setStart(true);
                            return "factory just started working";
                        }else return "not enough eggs";
                    case FEATHER:
                        if((pro = getFeather()) != null){
                            productions.remove(pro);
                            factory.setStart(true);
                            return "factory just started working";
                        }else return "not enough feather";
                    case MILK:
                        if((pro = getMilk()) != null){
                            productions.remove(pro);
                            factory.setStart(true);
                            return "factory just started working";
                        }else return "not enough milk";
                    case POCKET_MILK:
                        if((pro = getPocketMilk()) != null){
                            productions.remove(pro);
                            factory.setStart(true);
                            return "factory just started working";
                        }else return "not enough pocket milk";
                    case CLOTH:
                        if((pro = getCloth()) != null){
                            productions.remove(pro);
                            factory.setStart(true);
                            return "factory just started working";
                        }else return "not enough cloth";
                    case FLOUR:
                        if((pro = getFlour()) != null){
                            productions.remove(pro);
                            factory.setStart(true);
                            return "factory just started working";
                        }else return "not enough flour";
                }
            }
        }
        return "wrong factory name";
    }
    public String cage(String x , String y) {
        for (Wild wild : wilds) {
            int life=wild.getNeededTimeForBusting();
            if (life!=0) {
                if (x.equalsIgnoreCase(String.valueOf(wild.getX()))) {
                    if (y.equalsIgnoreCase(String.valueOf(wild.getY()))) {
                        life=wild.getNeededTimeForBusting();
                    }
                }
            }
            else {
                int p=wild.Kill();
            }
        }
        return "wrong factory name";
    }
    public String turn(String n)
    {
        for (int i = 1 ; i <= Integer.parseInt(n); i++) {
            if(well.isStart()){
                if(well.getTimeForPacking()==0){
                    well.setStart(false);
                    well.setWater();
                    well.setTimeForPacking();
                }else {
                    well.setTimeForPacking(well.getTimeForPacking()-1);
                }
            }
            for (Factory factory : factories) {
                if(factory.isStart()){
                    if(factory.getTimeForProducing()==0){
                        factory.setStart(false);
                        factory.setTimeForProducing();
                        ground.setProOn(factory.getProduct(),6,6);
                    }else {
                        factory.setTimeForProducing(factory.getTimeForProducing()-1);
                    }
                }
            }
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    Production pro = ground.getProduct()[k][j];
                    if(pro!=null){
                        if(pro.getTimeForPick()!=0)
                            pro.setTimeForPick(pro.getTimeForPick()-1);
                        else
                            ground.setProOff(j+1,k+1);
                    }
                }
            }
            for (Domestic domestic : domestics) {
                domestic.decreaseAge();
                domestic.move();
                if(domestic.getRemainingAge()<50){
                    domestic.eat();
                }
            }
            if (truck.isGo()){
                if(truck.getRemainingTimeBack()==0){
                    truck.setGo(false);
                    truck.setRemainingTimeBack();
                    money += truck.getMoney();
                    truck.setMoney();
                }else
                    truck.setRemainingTimeBack(truck.getRemainingTimeBack()-1);
            }


        }
        // check if mission completed
        return null;
    }
    public String truckLoad(String name) {
        Production pro = switch (name.toLowerCase(Locale.ROOT)) {
            case "egg" -> getEgg();
            case "milk" -> getMilk();
            case "feather" -> getFeather();
            case "flour" -> getFlour();
            case "pocket milk" -> getPocketMilk();
            case "cloth" -> getCloth();
            case "bread" -> getBread();
            case "ice cream" -> getIceCream();
            case "dress" -> getDress();
            default -> null;
        };
        if(pro!=null){
            productions.remove(pro);
            truck.truckLoad(pro);
            return "successful";
        }else
            return "wrong production";
    }
    public String truckUnload(String name)
    {
        Production pro = switch (name.toLowerCase(Locale.ROOT)) {
            case "egg" -> getEgg();
            case "milk" -> getMilk();
            case "feather" -> getFeather();
            case "flour" -> getFlour();
            case "pocket milk" -> getPocketMilk();
            case "cloth" -> getCloth();
            case "bread" -> getBread();
            case "ice cream" -> getIceCream();
            case "dress" -> getDress();
            default -> null;
        };
        if(pro!=null){
            productions.add(pro);
            truck.truckUnload(pro);
            return "successful";
        }else
            return "wrong production";
    }


    private Production getEgg(){
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase("egg"))
                return production;
        }
        return null;
    }
    private Production getFeather(){
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase("feather"))
                return production;
        }
        return null;
    }
    private Production getMilk(){
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase("milk"))
                return production;
        }
        return null;
    }
    private Production getFlour(){
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase("flour"))
                return production;
        }
        return null;
    }
    private Production getCloth(){
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase("cloth"))
                return production;
        }
        return null;
    }
    private Production getPocketMilk(){
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase("pocketMilk"))
                return production;
        }
        return null;
    }
    private Production getBread(){
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase("egg"))
                return production;
        }
        return null;
    }
    private Production getDress(){
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase("egg"))
                return production;
        }
        return null;
    }
    private Production getIceCream(){
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase("egg"))
                return production;
        }
        return null;
    }


    public String well() {
        if(well.getWater()!=0)
            return "well is not empty!";
        well.setStart(true);
        return "successful";

    }

    public void startCage() {
        this.startCage = true;
    }

    public void truckGO() {
        this.truckGO = true;
    }


}
