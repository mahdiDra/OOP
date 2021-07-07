public class Production {

    private String name;
    private int timeForPick;
    private int sellPrice;
    private int space;

    public Production(String name) {
        this.name = name;
        switch (name){
            case "egg" -> {
                this.timeForPick = 4;
                this.sellPrice = 15;
                this.space = 1;
            }
            case "feather" -> {
                this.timeForPick = 4;
                this.sellPrice = 20;
                this.space = 1;
            }
            case "milk" -> {
                this.timeForPick = 4;
                this.sellPrice = 25;
                this.space = 1;
            }
            case "cloth" -> {
                this.timeForPick = 5;
                this.sellPrice = 50;
                this.space = 2;
            }
            case "flour" -> {
                this.timeForPick = 5;
                this.sellPrice = 40;
                this.space = 2;
            }
            case "pocket milk" -> {
                this.timeForPick = 5;
                this.sellPrice = 60;
                this.space = 2;
            }
            case "tiger" -> {
                this.timeForPick = 5;
                this.sellPrice = 500;
                this.space = 15;
            }
            case "bear" -> {
                this.timeForPick = 5;
                this.sellPrice = 400;
                this.space = 15;
            }
            case "lion" -> {
                this.timeForPick = 5;
                this.sellPrice = 300;
                this.space = 15;
            }
            case "dress" -> {
                this.timeForPick = 6;
                this.sellPrice = 100;
                this.space = 4;
            }
            case "bread" -> {
                this.timeForPick = 6;
                this.sellPrice = 80;
                this.space = 4;
            }
            case "ice cream" -> {
                this.timeForPick = 6;
                this.sellPrice = 120;
                this.space = 4;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getTimeForPick() {
        return timeForPick;
    }

    public void setTimeForPick(int timeForPick) {
        this.timeForPick = timeForPick;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public int getSpace() {
        return space;
    }
}
