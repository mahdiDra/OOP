import java.util.Random;
public class HelperAnimal
{
    private String name;
    private int buyPrice;
    private int sellPrice;
    private int x;
    private int y;
    public HelperAnimal(String name)
    {
        this.name = name;
        switch (name) {
            case "dog" -> {
                this.buyPrice = 100;
                this.sellPrice=50;
            }
            case "cat" -> {
                this.buyPrice = 150;
                this.sellPrice=75;
            }
        }
        this.x = new Random().nextInt(7);
        this.y = new Random().nextInt(7);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public int getBuyPrice() {
        return buyPrice;
    }
}
