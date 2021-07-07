import java.awt.font.TextHitInfo;
import java.util.ArrayList;

public class Mission {

    private int level;
    private ArrayList<Wild> wilds;
    private int prizeCoin;
    private int maxTime;
    private int requiredCoin;
    private int requiredEgg;
    private int requiredMilk;
    private int requiredFeather;
    private int requiredFlour;
    private int requiredPocketMilk;
    private int requiredCloth;
    private int requiredBread;
    private int requiredIceCream;
    private int requiredDress;

    public Mission(int level,
                   int prizeCoin,
                   int maxTime,
                   int requiredCoin,
                   int requiredEgg,
                   int requiredMilk,
                   int requiredFeather,
                   int requiredFlour,
                   int requiredPocketMilk,
                   int requiredCloth,
                   int requiredBread,
                   int requiredIceCream,
                   int requiredDress) {
        this.wilds = new ArrayList<>();
        this.level = level;
        this.prizeCoin = prizeCoin;
        this.maxTime = maxTime;
        this.requiredCoin = requiredCoin;
        this.requiredEgg = requiredEgg;
        this.requiredMilk = requiredMilk;
        this.requiredFeather = requiredFeather;
        this.requiredFlour = requiredFlour;
        this.requiredPocketMilk = requiredPocketMilk;
        this.requiredCloth = requiredCloth;
        this.requiredBread = requiredBread;
        this.requiredIceCream = requiredIceCream;
        this.requiredDress = requiredDress;
    }
    public Mission(){
        this.wilds = new ArrayList<>();
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<Wild> getWilds() {
        return wilds;
    }

    public int getPrizeCoin() {
        return prizeCoin;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public int getRequiredCoin() {
        return requiredCoin;
    }

    public int getRequiredEgg() {
        return requiredEgg;
    }

    public int getRequiredMilk() {
        return requiredMilk;
    }

    public int getRequiredFeather() {
        return requiredFeather;
    }

    public int getRequiredFlour() {
        return requiredFlour;
    }

    public int getRequiredPocketMilk() {
        return requiredPocketMilk;
    }

    public int getRequiredCloth() {
        return requiredCloth;
    }

    public int getRequiredBread() {
        return requiredBread;
    }

    public int getRequiredIceCream() {
        return requiredIceCream;
    }

    public int getRequiredDress() {
        return requiredDress;
    }

    public Wild setWildOn(int localTime) {
        for (Wild wild : wilds) {
            if(wild.getAppearingTime() == localTime){
                wilds.remove(wild);
                return wild;
            }
        }
        return null;
    }
}
