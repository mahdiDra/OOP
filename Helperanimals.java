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
}
