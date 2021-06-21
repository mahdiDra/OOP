import java.util.ArrayList;

public class Truck {
    private ArrayList<Wild> wilds;
    private ArrayList<Domestic> domestics;
    private ArrayList<Helperanimals> helperanimals;
    private int egg;
    private int milk;
    private int feather;
    private int cloth;
    private int flour;
    private int pocketMilk;
    private int dress;
    private int iceCream;
    private int bread;
    private int space;
    private int money;


    public Truck() {
        this.wilds = new ArrayList<>();
        this.domestics = new ArrayList<>();
        this.helperanimals = new ArrayList<>();
        this.space = 15;
    }

    public void truckLoad(String str,int n){
        for (price value : price.values()) {
            if(str.equals(value.name())){
                switch (value) {
                    case EGG -> {
                        egg += n;
                        space -= n * spaces.EGG.space;
                    }
                    case FEATHER -> {
                        feather += n;
                        space -= n * spaces.FEATHER.space;
                    }
                    case MILK -> {
                        milk += n;
                        space -= n * spaces.MILK.space;
                    }
                    case FLOUR -> {
                        flour += n;
                        space -= n * spaces.FLOUR.space;
                    }
                    case CLOTH -> {
                        cloth += n;
                        space -= n * spaces.CLOTH.space;
                    }
                    case POCKET_MILK -> {
                        pocketMilk += n;
                        space -= n * spaces.POCKET_MILK.space;
                    }
                    case DRESS -> {
                        dress += n;
                        space -= n * spaces.DRESS.space;
                    }
                    case ICE_CREAM -> {
                        iceCream += n;
                        space -= n * spaces.ICE_CREAM.space;
                    }
                    case BREAD -> {
                        bread += n;
                        space -= n * spaces.BREAD.space;
                    }
                }
            }
        }
    }

    public void truckUnload(String str,int n){
        for (price value : price.values()) {
            if(str.equals(value.name())){
                switch (value) {
                    case EGG -> {
                        egg -= n;
                        space += n * spaces.EGG.space;
                    }
                    case FEATHER -> {
                        feather -= n;
                        space += n * spaces.FEATHER.space;
                    }
                    case MILK -> {
                        milk -= n;
                        space += n * spaces.MILK.space;
                    }
                    case FLOUR -> {
                        flour -= n;
                        space += n * spaces.FLOUR.space;
                    }
                    case CLOTH -> {
                        cloth -= n;
                        space += n * spaces.CLOTH.space;
                    }
                    case POCKET_MILK -> {
                        pocketMilk -= n;
                        space += n * spaces.POCKET_MILK.space;
                    }
                    case DRESS -> {
                        dress -= n;
                        space += n * spaces.DRESS.space;
                    }
                    case ICE_CREAM -> {
                        iceCream -= n;
                        space += n * spaces.ICE_CREAM.space;
                    }
                    case BREAD -> {
                        bread -= n;
                        space += n * spaces.BREAD.space;
                    }
                }
            }
        }
    }

    private enum price{
        EGG(15),
        FEATHER(20),
        MILK(25),
        FLOUR(40),
        CLOTH(50),
        POCKET_MILK(60),
        DRESS(100),
        ICE_CREAM(120),
        BREAD(80);

        int price;
        price(int i) {
            price = i;
        }
    }
    private enum spaces{
        EGG(1),
        FEATHER(1),
        MILK(1),
        FLOUR(2),
        CLOTH(2),
        POCKET_MILK(2),
        DRESS(4),
        ICE_CREAM(4),
        BREAD(4);

        int space;
        spaces(int i) {
            space = i;
        }
    }

    public int getSpace()
    {
        return space;
    }
    public int getaPrice()
    {
        space=15;
        return money;
    }
}
