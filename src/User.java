public class User {
    private String username;
    private String password;
    private int passedLevels;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.passedLevels = 0;
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
        this.passedLevels += 1;
    }

    public int getPassedLevels() {
        return passedLevels;
    }
}
