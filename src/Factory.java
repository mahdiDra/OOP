import java.util.Locale;

public class Factory {

    private String name;
    private String production;
    private Keys needs;
    private int buildPrice;
    private int timeForProducing;
    private boolean hasToStart;


    public Factory(String name) {
        this.hasToStart = false;
        switch (name.toLowerCase(Locale.ROOT)) {
            case "mill" -> {
                this.needs = Keys.EGG;
                this.name = "mill";
                this.production = "flour";
                this.buildPrice = 150;
                this.timeForProducing = 4;
            }
            case "milk packing" -> {
                this.needs = Keys.MILK;
                this.name = "milk packing";
                this.production = "pocket milk";
                this.buildPrice = 400;
                this.timeForProducing = 6;
            }
            case "cloth packing" -> {
                this.needs = Keys.FEATHER;
                this.name = "cloth packing";
                this.production = "cloth";
                this.buildPrice = 250;
                this.timeForProducing = 5;
            }
            case "bakery" -> {
                this.needs = Keys.FLOUR;
                this.name = "bakery";
                this.production = "bread";
                this.buildPrice = 250;
                this.timeForProducing = 5;
            }
            case "dressmaking" -> {
                this.needs = Keys.CLOTH;
                this.name = "dressmaking";
                this.production = "dress";
                this.buildPrice = 400;
                this.timeForProducing = 6;
            }
            case "ice cream shop" -> {
                this.needs = Keys.POCKET_MILK;
                this.name = "ice cream shop";
                this.production = "ice cream";
                this.buildPrice = 550;
                this.timeForProducing = 7;
            }
        }
    }


    public String getName()
    {
        return name;
    }

    public Keys getNeeds()
    {
        return needs;
    }


    public Production getProduct(){
        return new Production(this.production);
    }

    public boolean getHasToStart() {
        return hasToStart;
    }

    public void setHasToStart(boolean start) {
        this.hasToStart = start;
    }

    public int getTimeForProducing() {
        return timeForProducing;
    }

    public void setTimeForProducing(int timeForProducing) {
        this.timeForProducing = timeForProducing;
    }

    public void setTimeForProducing() {
        switch (this.name) {
            case "mill" -> this.timeForProducing = 4;
            case "milk packing", "dressmaking" -> this.timeForProducing = 6;
            case "cloth packing", "bakery" -> this.timeForProducing = 5;
            case "ice cream shop" -> this.timeForProducing = 7;
        }
    }

    public int getBuildPrice() {
        return buildPrice;
    }
}
