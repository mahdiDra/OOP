import java.util.Random;

public class Wild {
    private String name;
    private int sellPrice;
    private int speed;
    private int neededTimeForBusting;
    private int x;
    private int y;
    private int appearingTime;
    private boolean hasToBeArrested;

    public Wild(String name ,int appearingTime) {
        this.name = name;
        this.appearingTime = appearingTime;
        this.hasToBeArrested = false;
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

    public String getName() {
        return name;
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

    public int getNeededTimeForBusting() {
        return neededTimeForBusting;
    }

    public void setNeededTimeForBusting(int neededTimeForBusting) {
        this.neededTimeForBusting = neededTimeForBusting;
    }

    public boolean getHasToBeArrested() {
        return hasToBeArrested;
    }

    public void setHasToBeArrested(boolean hasToBeArrested) {
        this.hasToBeArrested = hasToBeArrested;
    }

    public int getAppearingTime() {
        return appearingTime;
    }

    public void turnNeededTimeForBustingBack() {
        switch (name) {
            case "lion" -> {
                if(this.neededTimeForBusting<3)
                    this.neededTimeForBusting++;
            }
            case "bear", "tiger" -> {
                if(this.neededTimeForBusting<4)
                    this.neededTimeForBusting++;
            }
        }
    }


    public void move(Ground ground){
        ground.setWildOff(this.x,this.y);
        int a = new Random().nextInt(4);
        switch (a) {
            case 0 -> {
                x += speed;
                if(speed == 2){
                    if(x<8){
                        if(ground.getProduct()[x-1][y] != null)
                            ground.setProOff(x-1,y);
                    }
                }
            }
            case 1 -> {
                x -= speed;
                if(speed == 2){
                    if(x>-1){
                        if(ground.getProduct()[x+1][y] != null)
                            ground.setProOff(x+1,y);
                    }
                }
            }
            case 2 -> {
                y += speed;
                if(speed == 2){
                    if(y<8){
                        if(ground.getProduct()[x][y-1] != null)
                            ground.setProOff(x,y-1);
                    }
                }
            }
            case 3 -> {
                y -= speed;
                if(speed == 2){
                    if(y>-1){
                        if(ground.getProduct()[x][y+1] != null)
                            ground.setProOff(x,y+1);
                    }
                }
            }
        }
        if(y<1)
            y+=2;
        else if(y>6)
            y-=2;
        else if (x<1)
            x+=2;
        else if (x>6)
            x-=2;
        ground.setWildOn(this);
    }

}
