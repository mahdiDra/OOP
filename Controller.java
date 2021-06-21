import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Controller {


    ArrayList<Domestic> domestics;
    ArrayList<Wild> wilds;
    ArrayList<Helperanimals> helperanimals ;
    ArrayList<Factory> factories;
    Ground ground;
    Truck truck;
    int egg,feather,milk,cloth,iceCream,flour,dress,bread,pocketMilk,well;
    int money=0;
    int wild;

    public Controller()
    {
        this.wilds = new ArrayList<>();
        this.domestics = new ArrayList<>();
        this.helperanimals = new ArrayList<>();
        this.ground = new Ground();
        this.factories = new ArrayList<>();
        this.truck = new Truck();
    }

    public String buyDomestic(String name)
    {
        //TODO
        domestics.add(new Domestic(name.toLowerCase(Locale.ROOT)));
        money -= domestics.get(domestics.size()-1).getPrice();
        return null;
    }
    public String pickup(String x , String y)
    {
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
    public String cage(String x , String y)
    {
        for (Wild wild : wilds)
        {
            int life=wild.getNeededTimeForBusting();
            if (life!=0)
            {
                if (x.equalsIgnoreCase(String.valueOf(wild.getX())))
                {
                if (y.equalsIgnoreCase(String.valueOf(wild.getY())))
                {
                    life=wild.getNeededTimeForBusting();
                }
                }
            }
            else
            {
                int p=wild.Kill();
            }
        }
        return "wrong factory name";
    }
    public String turn(String n)
    {
        return null;
    }
    public String truckLoad(String name,int n)
    {

        for (Truck truck: truck) {
            if (name.equalsIgnoreCase(truck.getName())){
                switch (truck.getNeeds())
                {
                    case "EGG":
                            return "factory just started working";
                    else
                            return "not enough eggs";
                    case "FEATHER":
                            truck.truckLoad();
                            return "factory just started working";
                    else
                        return "not enough feather";
                    case "MILK":
                            truck.truckLoad();
                            return "factory just started working";
                    else
                            return "not enough milk";
                    case "POCKET_MILK":
                            truck.truckLoad();
                            return "factory just started working";
                        else return "not enough pocket milk";
                    case "CLOTH":
                            truck.truckLoad();
                            return "factory just started working";
                        else return "not enough cloth";
                    case "FLOUR":
                            truck.truckLoad();
                            return "factory just started working";
                        else
                            return "not enough flour";
                }
            }
        }
        return "wrong factory name";
    }
    public void move(int n)
    {
        for(int i=0;i<n;i++)
        {
            for (Domestic domestic : domestics)
            {
                int f = new Random().nextInt(5);
                if (f == 1) {
                    domestic.goright();
                }
                if (f == 2) {
                    domestic.goleft();
                }
                if (f == 3) {
                    domestic.goup();
                }
                if (f == 4) {
                    domestic.godown();
                }
            }
            for (Wild wild : wilds)
            {
                int f = new Random().nextInt(5);
                if (f == 1) {
                    wild.goright();
                }
                if (f == 2) {
                    wild.goleft();
                }
                if (f == 3) {
                    wild.goup();
                }
                if (f == 4) {
                    wild.godown();
                }
            }
            for (Helperanimals helperanimal : helperanimals)
            {
                int f = new Random().nextInt(5);
                if (f == 1) {
                    helperanimal.goright();
                }
                if (f == 2) {
                    helperanimal.goleft();
                }
                if (f == 3) {
                    helperanimal.goup();
                }
                if (f == 4) {
                    helperanimal.godown();
                }
            }
        }
    }
    public String truckUnload(String name)
    {
        return null;
    }
    public Integer truckGo()
    {
        return truck.getaPrice();
    }
}
