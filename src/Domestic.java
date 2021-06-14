import java.util.Locale;
import java.util.Random;

public class Domestic {
    private String name;
    private int price;
    private String production;
    private int neededTimeForProducing;
    private int remainingAge;
    private int x;
    private int y;

    public Domestic(String name) {
        this.name = name;
        this.remainingAge = 100;
        switch (name) {
            case "hen" -> {
                this.price = 100;
                this.production = "egg";
                this.neededTimeForProducing = 2;
            }
            case "turkey" -> {
                this.price = 200;
                this.production = "feather";
                this.neededTimeForProducing = 3;
            }
            case "buffalo" -> {
                this.price = 400;
                this.production = "milk";
                this.neededTimeForProducing = 5;
            }
        }
        this.x = new Random().nextInt(7);
        this.y = new Random().nextInt(7);
    }


    public int getPrice() {
        return price;
    }
}
