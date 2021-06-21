import java.util.ArrayList;

public class Ground {

    private boolean[][] plant = new boolean[6][6];

    public void setOnPlant(int x , int y){
        plant[x-1][y-1] = true;
    }
    public void setOffPlant(int x , int y){
        plant[x-1][y-1] = false;
    }

    private Production[][] product = new Production[6][6];

    public void setProOn(Production production , int x , int y){
        product[x-1][y-1] = production;
    }
    public void setProOff(int x , int y){
        product[x-1][y-1] = null;
    }

    public Keys getOut(int x , int y) {
        for (Keys value : Keys.values()) {
            if(value.toString().equalsIgnoreCase(product[x-1][y-1].getName()))
                return value;
        }
        return null;
    }

    public Production[][] getProduct() {
        return product;
    }
}
