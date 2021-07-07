
import java.util.Random;

public class Domestic {
    private String name;
    private int buyPrice;
    private int sellPrice;
    private String production;
    private int neededTimeForProducing;
    private int remainingAge;
    private int x;
    private int y;

    public Domestic(String name, int buyPrice,String production,int neededTimeForProducing) {
        this.name = name;
        this.remainingAge = 100;
        this.buyPrice = buyPrice;
        this.production = production;
        this.neededTimeForProducing = neededTimeForProducing;
        this.x = new Random().nextInt(7);
        this.y = new Random().nextInt(7);
    }

    public Production getPro(){
        return new Production(production);
    }


    public int getNeededTimeForProducing() {
        return neededTimeForProducing;
    }

    public void setNeededTimeForProducing(int neededTimeForProducing) {
        this.neededTimeForProducing = neededTimeForProducing;
    }

    public void setNeededTimeForProducing() {
        switch (name){
            case "hen" -> this.neededTimeForProducing = 2;
            case "turkey" -> this.neededTimeForProducing = 3;
            case "buffalo" -> this.neededTimeForProducing = 5;
        }
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPrice() {
        return buyPrice;
    }

    public void decreaseAge(){
        this.remainingAge -= 10;
    }

    public int getRemainingAge() {
        return remainingAge;
    }

    public void setRemainingAge() {
        this.remainingAge = 100;
    }

    public void eat(){
        this.remainingAge = 100;
    }

    public String getName() {
        return name;
    }

    public void move(){
        int a = new Random().nextInt(4);
        switch (a) {
            case 0 -> x++;
            case 1 -> x--;
            case 2 -> y++;
            case 3 -> y--;
        }
        if(y<1)
            y+=2;
        else if(y>6)
            y-=2;
        else if (x<1)
            x+=2;
        else if (x>6)
            x-=2;
    }
}
