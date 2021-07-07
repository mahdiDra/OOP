import java.util.ArrayList;
import java.util.Locale;

public class Controller {

    private ArrayList<Domestic> domestics;
    private ArrayList<HelperAnimal> helperAnimals;
    private ArrayList<Factory> factories;
    private ArrayList<Production> productions;
    private int money = 200;
    private int localTime = 0;

    private Ground ground;
    private Well well;
    private Truck truck;
    private Mission mission;


    public Controller(Mission mission)
    {
        this.mission = mission;
        this.domestics = new ArrayList<>();
        this.helperAnimals = new ArrayList<>();
        this.ground = new Ground();
        this.factories = new ArrayList<>();
        this.truck = new Truck();
        this.well = new Well();
        this.productions = new ArrayList<>();
    }

    public String buyDomesticOrHelper(String name)
    {
        name = name.toLowerCase(Locale.ROOT);
        switch (name) {
            case "hen" -> {
                if(money>=100){
                    domestics.add(new Domestic(name,100,"egg",2));
                    money-=100;
                    return "successful";
                }else
                    return "not enough money!";
            }
            case "turkey" -> {
                if(money>=200){
                    domestics.add(new Domestic(name,200,"feather",3));
                    money-=200;
                    return "successful";
                }else
                    return "not enough money!";
            }
            case "buffalo" -> {
                if(money>=400){
                    domestics.add(new Domestic(name,400,"milk",5));
                    money-=400;
                    return "successful";
                }else
                    return "not enough money!";
            }
            case "dog" , "cat" -> {
                HelperAnimal newD = new HelperAnimal(name);
                if(money>=newD.getBuyPrice()){
                    helperAnimals.add(newD);
                    money-=newD.getBuyPrice();
                    return "successful";
                }else
                    return "not enough money!";
            }
            default -> {return "Invalid name!";}
        }
    }
    public String pickup(String x , String y)
    {
        Production a = ground.getOut(Integer.parseInt(x),Integer.parseInt(y));
        if( a != null){
            productions.add(a);
            ground.setProOff(Integer.parseInt(x),Integer.parseInt(y));
            // check if mission completed
            if(levelCompleted()){
                View.levelCompleted = true;
                if(localTime<= mission.getMaxTime())
                    return "level completed\nyou prize coin is: "+mission.getPrizeCoin();
                return "level completed";
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
                            factory.setHasToStart(true);
                            return "factory just started working";
                        }else return "not enough eggs";
                    case FEATHER:
                        if((pro = getFeather()) != null){
                            productions.remove(pro);
                            factory.setHasToStart(true);
                            return "factory just started working";
                        }else return "not enough feather";
                    case MILK:
                        if((pro = getMilk()) != null){
                            productions.remove(pro);
                            factory.setHasToStart(true);
                            return "factory just started working";
                        }else return "not enough milk";
                    case POCKET_MILK:
                        if((pro = getPocketMilk()) != null){
                            productions.remove(pro);
                            factory.setHasToStart(true);
                            return "factory just started working";
                        }else return "not enough pocket milk";
                    case CLOTH:
                        if((pro = getCloth()) != null){
                            productions.remove(pro);
                            factory.setHasToStart(true);
                            return "factory just started working";
                        }else return "not enough cloth";
                    case FLOUR:
                        if((pro = getFlour()) != null){
                            productions.remove(pro);
                            factory.setHasToStart(true);
                            return "factory just started working";
                        }else return "not enough flour";
                }
            }
        }
        return "wrong factory name";
    }

    public String build(String name){
        Factory fac = new Factory(name);
        if(money<fac.getBuildPrice())
            return "not enough money";
        factories.add(fac);
        return "factory build successfully";
    }

    public String cage(String x , String y) {
        Wild wild = ground.getWild(Integer.parseInt(x),Integer.parseInt(y));
        if(wild==null)
            return "no wild exist in this point";
        wild.setHasToBeArrested(true);
        return "successful";
    }

    public String turn(String n)
    {
        for (int i = 0 ; i < Integer.parseInt(n); i++) {
            if(well.getHasToStart()){
                if(well.getTimeForPacking()==0){
                    well.setHasToStart(false);
                    well.setWater();
                    well.setTimeForPacking();
                }else {
                    well.setTimeForPacking(well.getTimeForPacking()-1);
                }
            }
            for (Factory factory : factories) {
                if(factory.getHasToStart()){
                    if(factory.getTimeForProducing()==0){
                        factory.setHasToStart(false);
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
                        if(ground.getWild(k+1,j+1) != null)
                            ground.setProOff(j+1,k+1);
                        else {
                            if(pro.getTimeForPick()!=0)
                                pro.setTimeForPick(pro.getTimeForPick()-1);
                            else
                                ground.setProOff(j+1,k+1);
                        }
                    }
                }
            }
            for (Domestic domestic : domestics) {
                if(ground.getWild(domestic.getX(),domestic.getY()) != null)
                    domestics.remove(domestic);
                else {
                    domestic.decreaseAge();
                    domestic.move();
                    if(domestic.getRemainingAge()<50){
                        if(ground.getPlant(domestic.getX(),domestic.getY())){
                            domestic.eat();
                            ground.setOffPlant(domestic.getX(),domestic.getY());
                        }
                    }
                    if(domestic.getNeededTimeForProducing()==0){
                        domestic.setNeededTimeForProducing();
                        ground.setProOn(domestic.getPro(),domestic.getX(),domestic.getY());
                    }else {
                        domestic.setNeededTimeForProducing(domestic.getNeededTimeForProducing()-1);
                    }
                }
            }
            if (truck.getHasToGo()){
                if(truck.getRemainingTimeBack()==0){
                    truck.setHasToGo(false);
                    truck.setRemainingTimeBack();
                    money += truck.getMoney();
                }else
                    truck.setRemainingTimeBack(truck.getRemainingTimeBack()-1);
            }
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    Wild wild = ground.getWild(j+1,k+1);
                    if(wild!=null){
                        if(wild.getHasToBeArrested()){
                            wild.setHasToBeArrested(false);
                            if(wild.getNeededTimeForBusting()==0){
                                ground.setProOn(new Production(wild.getName()),wild.getX(),wild.getY());
                                ground.setWildOff(j+1,k+1);
                            }else{
                                wild.setNeededTimeForBusting(wild.getNeededTimeForBusting()-1);
                                wild.move(this.ground);
                            }
                        }else{
                            wild.turnNeededTimeForBustingBack();
                            wild.move(this.ground);
                        }
                    }
                }
            }
            for (HelperAnimal helperAnimal : helperAnimals) {
                if(ground.getWild(helperAnimal.getX(),helperAnimal.getY()) != null){
                    if(helperAnimal.getName().equals("dog")){
                        ground.setWildOff(helperAnimal.getX(),helperAnimal.getY());
                    }
                    helperAnimals.remove(helperAnimal);
                }else {
                    if(ground.getProduct()[helperAnimal.getX()][helperAnimal.getY()] != null){
                        productions.add(ground.getOut(helperAnimal.getX(),helperAnimal.getY()));
                        ground.setProOff(helperAnimal.getX(),helperAnimal.getY());
                    }
                    helperAnimal.move();
                }
            }
            mission.setWildOn(localTime);
            localTime++;
        }
        return getOutput();
    }

    public String truckGO() {
        this.truck.setHasToGo(true);
        return "truck is leaving";
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
            case "lion" -> getLion();
            case "tiger" -> getTiger();
            case "bear" -> getBear();
            default -> null;
        };
        if(pro!=null){
            if(truck.truckLoad(pro))
                productions.remove(pro);
            else return "not enough space in truck";
        }else return "no "+name+" found!";
        return "successful";
    }
    public String truckUnload(String name)
    {
        Production pro = truck.truckProUnload(name);
        if(pro!=null){
            productions.add(pro);
            return "successful";
        }else return "no "+name+" is in truck!";
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
    private Production getTiger(){
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase("tiger"))
                return production;
        }
        return null;
    }
    private Production getLion(){
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase("lion"))
                return production;
        }
        return null;
    }
    private Production getBear(){
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase("bear"))
                return production;
        }
        return null;
    }
    private int getAllProductions(String in){
        int a = 0;
        for (Production production : productions) {
            if(production.getName().equalsIgnoreCase(in))
                a++;
        }
        return a;
    }


    public String well() {
        if(well.getWater()!=0)
            return "well is not empty!";
        well.setHasToStart(true);
        return "successful";
    }

    private boolean levelCompleted(){
        if(getAllProductions("egg")<mission.getRequiredEgg())
            return false;
        else if(getAllProductions("milk")<mission.getRequiredMilk())
            return false;
        else if (getAllProductions("feather")<mission.getRequiredFeather())
            return false;
        else if (getAllProductions("flour")<mission.getRequiredFlour())
            return false;
        else if(getAllProductions("pocket milk")<mission.getRequiredPocketMilk())
            return false;
        else if(getAllProductions("cloth")<mission.getRequiredCloth())
            return false;
        else if(getAllProductions("bread")<mission.getRequiredBread())
            return false;
        else if (getAllProductions("ice cream")< mission.getRequiredIceCream())
            return false;
        else if (getAllProductions("dress")<mission.getRequiredDress())
            return false;
        else return money >= mission.getRequiredCoin();
    }
    public String getOutput(){
        StringBuilder out = new StringBuilder();
        out.append(localTime).append("\n");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(ground.getPlant(i+1,j+1))
                    out.append("1 ");
                else out.append("0 ");
            }
            out.append("\n");
        }
        for (Domestic domestic : domestics) {
            out.append(domestic.getName()).append(" ").append(domestic.getRemainingAge()).append("% [").append(domestic.getX()).append(" ").append(domestic.getY()).append("]\n");
        }
        for (HelperAnimal helperAnimal : helperAnimals) {
            out.append(helperAnimal.getName()).append("[").append(helperAnimal.getX()).append(" ").append(helperAnimal.getY()).append("]\n");
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                Wild wild;
                if((wild = ground.getWild(i+1,j+1)) != null)
                    out.append(wild.getName()).append(" ").append(wild.getNeededTimeForBusting()).append(" [").append(wild.getX()).append(" ").append(wild.getY()).append("]\n");
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                Production pro;
                if((pro = ground.getProduct()[i+1][j+1]) != null)
                    out.append(pro.getName()).append(" ").append(" [").append(i+1).append(" ").append(j+1).append("]\n");
            }
        }
        out.append("Coin: ").append(money).append("/").append(mission.getRequiredCoin()).append("\n");
        if(mission.getRequiredEgg()!=0)
            out.append("Egg: ").append(getAllProductions("egg")).append("/").append(mission.getRequiredEgg()).append("\n");
        if(mission.getRequiredMilk()!=0)
            out.append("Milk: ").append(getAllProductions("milk")).append("/").append(mission.getRequiredMilk()).append("\n");
        if(mission.getRequiredFeather()!=0)
            out.append("Feather: ").append(getAllProductions("feather")).append("/").append(mission.getRequiredFeather()).append("\n");
        if(mission.getRequiredPocketMilk()!=0)
            out.append("Pocket Milk: ").append(getAllProductions("pocket milk")).append("/").append(mission.getRequiredPocketMilk()).append("\n");
        if(mission.getRequiredFlour()!=0)
            out.append("Flour: ").append(getAllProductions("flour")).append("/").append(mission.getRequiredFlour()).append("\n");
        if(mission.getRequiredCloth()!=0)
            out.append("Cloth: ").append(getAllProductions("cloth")).append("/").append(mission.getRequiredCloth()).append("\n");
        if(mission.getRequiredIceCream()!=0)
            out.append("Ice Cream: ").append(getAllProductions("ice cream")).append("/").append(mission.getRequiredIceCream()).append("\n");
        if(mission.getRequiredBread()!=0)
            out.append("Bread: ").append(getAllProductions("bread")).append("/").append(mission.getRequiredBread()).append("\n");
        if(mission.getRequiredDress()!=0)
            out.append("Dress: ").append(getAllProductions("dress")).append("/").append(mission.getRequiredDress()).append("\n");
        return out.toString();
    }
}
