import java.util.Random;
public class Helperanimals
{
    private String name;
    private int buyprice;
    private int sellprice;
    private boolean existence;
    private int x;
    private int y;
    public Helperanimals(String name)
    {
        this.name = name;
        this.existence=true;
        switch (name) {
            case "dog" -> {
                this.buyprice = 100;
                this.sellprice=50;
            }
            case "cat" -> {
                this.buyprice = 150;
                this.sellprice=75;
            }
        }
        this.x = new Random().nextInt(7);
        this.y = new Random().nextInt(7);
    }
}
