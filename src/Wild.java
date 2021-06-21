import java.util.Random;

public class Wild {
    private String name;
    private int sellPrice;
    private int speed;
    private int neededTimeForBusting;
    private int remainingAge;
    private int x;
    private int y;

    public Wild(String name) {
        this.name = name;
        this.remainingAge = 100;
        switch (name) {
            case "lion" -> {
                this.sellPrice = 300;
                this.speed = 1;
                this.neededTimeForBusting = 3;
            }
            case "bear" -> {
                this.speed = 1;
                this.sellPrice = 400;
                this.neededTimeForBusting = 4;
            }
            case "tiger" -> {
                this.speed = 2;
                this.sellPrice = 500;
                this.neededTimeForBusting = 4;
            }
        }
        this.x = new Random().nextInt(7);
        this.y = new Random().nextInt(7);
    }


    public int getPrice()
    {
        return sellPrice;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getNeededTimeForBusting()
    {
        neededTimeForBusting--;
        return neededTimeForBusting;
    }
    public int Kill()
    {
        speed=0;
        return 0;
    }
}