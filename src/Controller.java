import java.util.ArrayList;
import java.util.Locale;

public class Controller {


    ArrayList<Domestic> domestics;
    ArrayList<Wild> wilds;
    ArrayList<Factory> factories;
    Ground ground;
    Truck truck;
    int egg,feather,milk,cloth,iceCream,flour,dress,bread,pocketMilk,well;
    int money;

    public Controller() {
        this.wilds = new ArrayList<>();
        this.domestics = new ArrayList<>();
        this.ground = new Ground();
        this.factories = new ArrayList<>();
        this.truck = new Truck();
    }

    public String buyDomestic(String name){
        //TODO
        domestics.add(new Domestic(name.toLowerCase(Locale.ROOT)));
        money -= domestics.get(domestics.size()-1).getPrice();
        return null;
    }
    public String pickup(String x , String y){
        return null;
    }
    public String well(){
        if(well != 0)
            return "bucket is not empty!";
        well = 5;
        return "successful";
    }
    public String plant(String x , String y){
        if(well == 0)
            return "empty bucket";
        well--;
        ground.setOnPlant(Integer.parseInt(x),Integer.parseInt(y));
        return "successful";
    }
    public String work(String name){
        for (Factory factory : factories) {
            if (name.equalsIgnoreCase(factory.getName())){
                switch (factory.getNeeds()){
                    case EGG:
                        if(egg != 0){
                            egg--;
                            factory.start();
                            return "factory just started working";
                        }else return "not enough eggs";
                    case FEATHER:
                        if(feather != 0){
                            feather--;
                            factory.start();
                            return "factory just started working";
                        }else return "not enough feather";
                    case MILK:
                        if(milk != 0){
                            milk--;
                            factory.start();
                            return "factory just started working";
                        }else return "not enough milk";
                    case POCKET_MILK:
                        if(pocketMilk != 0){
                            pocketMilk--;
                            factory.start();
                            return "factory just started working";
                        }else return "not enough pocket milk";
                    case CLOTH:
                        if(cloth != 0){
                            cloth--;
                            factory.start();
                            return "factory just started working";
                        }else return "not enough cloth";
                    case FLOUR:
                        if(flour != 0){
                            flour--;
                            factory.start();
                            return "factory just started working";
                        }else return "not enough flour";
                }
            }
        }
        return "wrong factory name";
    }
    public String cage(String x , String y){
        return null;
    }
    public String turn(String n){
        return null;
    }
    public String truckLoad(String name){
        return null;
    }
    public String truckUnload(String name){
        return null;
    }
    public String truckGo(){
        return null;
    }
}
