public class User {
    private String username;
    private String password;
    private int reachableLevels;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.reachableLevels = 1;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void passedPlus(){
        this.reachableLevels += 1;
    }

    public int getReachableLevels() {
        return reachableLevels;
    }
}
