public class Factory {

    String name;
    String production;
    Keys needs;
    int buildPrice;
    int timeForProducing;

    public Factory(Keys needs) {
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


    public int start(){
        //TODO
        return 1;
    }
}
