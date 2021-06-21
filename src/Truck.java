import java.util.ArrayList;

public class Truck {
    private ArrayList<Wild> wilds;
    private ArrayList<Domestic> domestics;
    private ArrayList<HelperAnimal> helperAnimals;
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
    private boolean go;
    private int remainingTimeBack;


    public Truck() {
        this.wilds = new ArrayList<>();
        this.domestics = new ArrayList<>();
        this.helperAnimals = new ArrayList<>();
        this.space = 15;
        this.remainingTimeBack = 10;
    }

    public void truckLoad(Production pro){
        for (price value : price.values()) {
            if(pro.getName().equals(value.name())){
                switch (value) {
                    case EGG -> {
                        egg ++;
                        space -= spaces.EGG.space;
                    }
                    case FEATHER -> {
                        feather ++;
                        space -= spaces.FEATHER.space;
                    }
                    case MILK -> {
                        milk ++;
                        space -= spaces.MILK.space;
                    }
                    case FLOUR -> {
                        flour ++;
                        space -= spaces.FLOUR.space;
                    }
                    case CLOTH -> {
                        cloth ++;
                        space -= spaces.CLOTH.space;
                    }
                    case POCKET_MILK -> {
                        pocketMilk ++;
                        space -= spaces.POCKET_MILK.space;
                    }
                    case DRESS -> {
                        dress ++;
                        space -= spaces.DRESS.space;
                    }
                    case ICE_CREAM -> {
                        iceCream ++;
                        space -= spaces.ICE_CREAM.space;
                    }
                    case BREAD -> {
                        bread ++;
                        space -= spaces.BREAD.space;
                    }
                }
            }
        }
    }

    public void truckUnload(Production pro){
        for (price value : price.values()) {
            if(pro.getName().equals(value.name())){
                switch (value) {
                    case EGG -> {
                        egg --;
                        space += spaces.EGG.space;
                    }
                    case FEATHER -> {
                        feather --;
                        space += spaces.FEATHER.space;
                    }
                    case MILK -> {
                        milk --;
                        space += spaces.MILK.space;
                    }
                    case FLOUR -> {
                        flour --;
                        space += spaces.FLOUR.space;
                    }
                    case CLOTH -> {
                        cloth --;
                        space += spaces.CLOTH.space;
                    }
                    case POCKET_MILK -> {
                        pocketMilk --;
                        space += spaces.POCKET_MILK.space;
                    }
                    case DRESS -> {
                        dress --;
                        space += spaces.DRESS.space;
                    }
                    case ICE_CREAM -> {
                        iceCream --;
                        space += spaces.ICE_CREAM.space;
                    }
                    case BREAD -> {
                        bread --;
                        space += spaces.BREAD.space;
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

    public boolean isGo() {
        return go;
    }

    public void setGo(boolean go) {
        this.go = go;
    }

    public int getRemainingTimeBack() {
        return remainingTimeBack;
    }

    public void setRemainingTimeBack(int remainingTimeBack) {
        this.remainingTimeBack = remainingTimeBack;
    }

    public void setRemainingTimeBack() {
        this.remainingTimeBack = 10;
    }

    public int getMoney(){
        money+=egg*price.EGG.price;
        egg = 0;
        money+=milk*price.MILK.price;
        milk = 0;
        money+=feather*price.FEATHER.price;
        feather = 0;
        money+=cloth*price.CLOTH.price;
        cloth = 0;
        money+=flour*price.FLOUR.price;
        flour = 0;
        money+=pocketMilk*price.POCKET_MILK.price;
        pocketMilk = 0;
        money+=dress*price.DRESS.price;
        dress = 0;
        money+=iceCream*price.ICE_CREAM.price;
        iceCream = 0;
        money+=bread*price.BREAD.price;
        bread = 0;
        space = 15;
        return money;
    }

    public void setMoney() {
        this.money = 0;
    }
}
