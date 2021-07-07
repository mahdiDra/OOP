public class Well {

    private int water;
    private int timeForPacking;
    private boolean hasToStart;

    public Well() {
        this.water = 5;
        this.timeForPacking = 3;
        this.hasToStart = false;
    }

    public void setTimeForPacking(int timeForPacking) {
        this.timeForPacking = timeForPacking;
    }

    public void setTimeForPacking() {
        this.timeForPacking = 3;
    }

    public int getTimeForPacking() {
        return timeForPacking;
    }

    public int getWater() {
        return water;
    }

    public void decreaseSpace(){ this.water--; }

    public void setWater() {
        this.water = 5;
    }

    public boolean getHasToStart() {
        return hasToStart;
    }

    public void setHasToStart(boolean start) {
        this.hasToStart = start;
    }
}
