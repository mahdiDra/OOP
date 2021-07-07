import java.util.ArrayList;

public class Ground {

    private boolean[][] plant ;
    private Production[][] product ;
    private Wild[][] wilds ;

    public Ground() {
        this.plant = new boolean[6][6];
        this.product = new Production[6][6];
        this.wilds = new Wild[6][6];
    }

    public void setProOn(Production production , int x , int y){
        product[x-1][y-1] = production;
    }
    public void setProOff(int x , int y){
        product[x-1][y-1] = null;
        wilds[x-1][y-1] = null;
    }
    public void setOnPlant(int x , int y){
        plant[x-1][y-1] = true;
    }
    public void setOffPlant(int x , int y){
        plant[x-1][y-1] = false;
    }
    public Wild getWild(int x , int y){
        return wilds[x-1][y-1];
    }
    public void setWildOff(int x , int y){
        wilds[x-1][y-1] = null;
    }

    public void setWildOn(Wild wild){
        wilds[wild.getX()-1][wild.getY()-1] = wild;
    }

    public boolean getPlant(int x , int y) {
        return plant[x-1][y-1];
    }

    public Production getOut(int x , int y) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(wilds[i][j] != null)
                    return new Production(wilds[i][j].getName());
                if(product[i][j]!=null)
                    return product[i][j];
            }
        }
        return null;
    }

    public Production[][] getProduct() {
        return product;
    }
}
