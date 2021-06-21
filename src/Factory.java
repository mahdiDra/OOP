public class Factory {

    private String name;
    private String production;
    private Keys needs;
    private int buildPrice;
    private int timeForProducing;
    private boolean start;


    public Factory(Keys needs) {
        this.start = false;
        switch (needs) {
            case EGG -> {
                this.needs = Keys.EGG;
                this.name = "mill";
                this.production = "flour";
                this.buildPrice = 150;
                this.timeForProducing = 4;
            }
            case MILK -> {
                this.needs = Keys.MILK;
                this.name = "milk packing";
                this.production = "pocket milk";
                this.buildPrice = 400;
                this.timeForProducing = 6;
            }
            case FEATHER -> {
                this.needs = Keys.FEATHER;
                this.name = "cloth packing";
                this.production = "cloth";
                this.buildPrice = 250;
                this.timeForProducing = 5;
            }
            case FLOUR -> {
                this.needs = Keys.FLOUR;
                this.name = "bakery";
                this.production = "bread";
                this.buildPrice = 250;
                this.timeForProducing = 5;
            }
            case CLOTH -> {
                this.needs = Keys.CLOTH;
                this.name = "dressmaking";
                this.production = "dress";
                this.buildPrice = 400;
                this.timeForProducing = 6;
            }
            case POCKET_MILK -> {
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

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
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
}
