import java.util.Random;

public class Wild {
    private String name;
    private int sellprice;
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
                this.sellprice = 300;
                this.speed = 1;
                this.neededTimeForBusting = 3;
            }
            case "bear" -> {
                this.speed = 1;
                this.sellprice = 400;
                this.neededTimeForBusting = 4;
            }
            case "tiger" -> {
                this.speed = 2;
                this.sellprice = 500;
                this.neededTimeForBusting = 4;
            }
        }
        this.x = new Random().nextInt(7);
        this.y = new Random().nextInt(7);
    }


    public int getPrice()
    {
        return sellprice;
    }
    public void goright()
    {
        if (x==6)
        {
            x=x-1;
        }
        else
        {
            x=x+1;
        }
    }
    public void godown()
    {
        if (y==6)
        {
            y=y-1;
        }
        else
        {
            y=y+1;
        }
    }
    public void goleft()
    {
        if (x==1)
        {
            x=x+1;
        }
        else
        {
            x=x-1;
        }
    }
    public void goup()
    {
        if (y==1)
        {
            y=y+1;
        }
        else
        {
            y=y-1;
        }
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