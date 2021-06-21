import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UserController {

    ArrayList<User> users;
    ObjectMapper mapper;
    File usersFile;

    public UserController() {
        this.users = new ArrayList<>();
        this.mapper = new ObjectMapper();
        this.usersFile = new File("users.txt");
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(usersFile,users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUsername(String username){
        try {
            users = mapper.readValue(usersFile,mapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (User user : users) {
            if(user.getUsername().equals(username))
                return false;
        }
        return true;
    }
    public void addUser(String username, String password){
        users.add(new User(username,password));
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(usersFile,users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPassword(String pass,String username){
        try {
            users = mapper.readValue(usersFile,mapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (User user : users) {
            if (user.getUsername().equals(username))
                if (user.getPassword().equals(pass))
                    return true;
        }
        return false;
    }

    public User getUser(String username){
        try {
            users = mapper.readValue(usersFile,mapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (User user : users) {
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }


}
