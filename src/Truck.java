import java.util.ArrayList;
import java.util.Locale;

public class Truck {
    private ArrayList<Production> productions;
    private ArrayList<Domestic> domestics;
    private ArrayList<HelperAnimal> helperAnimals;

    private int space;
    private int money;
    private boolean hasToGo;
    private int remainingTimeBack;


    public Truck() {
        this.productions = new ArrayList<>();
        this.domestics = new ArrayList<>();
        this.helperAnimals = new ArrayList<>();
        this.space = 15;
        this.remainingTimeBack = 10;
    }

    public boolean truckLoad(Production pro){
        if(space >= pro.getSpace()){
            productions.add(pro);
            space -= pro.getSpace();
            return true;
        }
        return false;
    }


    public Production truckProUnload(String name){
        for (Production production : productions) {
            if(production.getName().equals(name)){
                productions.remove(production);
                return production;
            }
        }
        return null;
    }


    public boolean getHasToGo() {
        return hasToGo;
    }

    public void setHasToGo(boolean a) {
        this.hasToGo = a;
    }

    public int getRemainingTimeBack() {
        return remainingTimeBack;
    }

    public void setRemainingTimeBack(int remainingTimeBack) {
        this.remainingTimeBack = remainingTimeBack;
    }

    public void setRemainingTimeBack() {
        this.remainingTimeBack = 10;
        this.money = 0;
    }

    public int getMoney(){
        for (Production production : productions) {
            money+=production.getSellPrice();
        }
        space = 15;
        return money;
    }



}
