public class Ground {

    boolean[][] plant = new boolean[6][6];


    public void setOnPlant(int x , int y){
        plant[x-1][y-1] = true;
    }
    public void setOffPlant(int x , int y){
        plant[x-1][y-1] = false;
    }

}
