public class Production {

    private String name;
    private int timeForPick;

    public Production(String name) {
        this.name = name;
        switch (name){
            case "egg" , "feather" , "milk" -> this.timeForPick = 4;
            case "cloth" , "flour" , "pocket milk" -> this.timeForPick = 5;
            case "dress" , "bread" , "ice cream" -> this.timeForPick = 6;
        }
    }

    public String getName() {
        return name;
    }

    public int getTimeForPick() {
        return timeForPick;
    }

    public void setTimeForPick(int timeForPick) {
        this.timeForPick = timeForPick;
    }
}
