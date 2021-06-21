import java.util.Random;
public class HelperAnimal
{
    private String name;
    private int buyPrice;
    private int sellPrice;
    private boolean existence;
    private int x;
    private int y;
    public HelperAnimal(String name)
    {
        this.name = name;
        this.existence=true;
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
}
