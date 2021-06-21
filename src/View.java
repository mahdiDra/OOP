import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

public class View {

    Controller controller;
    UserController userController;
    String input = "";
    Scanner scanner;
    User user;
    public static boolean levelCompleted;
    private ObjectMapper mapper;
    private File file;

    public View() {
        this.scanner = new Scanner(System.in);
        this.userController = new UserController();
        this.mapper = new ObjectMapper();
        this.file = new File("missions.txt");
    }

    public void userCheck(){
        while (!input.equalsIgnoreCase("exit")&&!(input = scanner.nextLine()).equalsIgnoreCase("exit")){
            Orders order = check(input);
            if (order != null) {
                switch (order) {
                    case LOGIN -> {
                        this.user = login();
                    }
                    case SIGNUP -> signup();
                    default -> System.out.println("invalid command");
                }
            }
            else System.out.println("invalid command");
        }
    }

    public void menu(){
        while (!input.equalsIgnoreCase("exit")&&!(input = scanner.nextLine()).equalsIgnoreCase("exit")){
            Orders order = check(input);
            if (order != null) {
                switch (order) {
                    case START -> {
                        levelCompleted = false;
                        int level = Integer.parseInt(check(order,input).group(1));
                        if(user.getPassedLevels() >= level){
                            Mission mi;
                            if(( mi = getMission(level)) != null){
                                this.controller = new Controller(mi);
                                run();
                            }else
                            System.out.println("this level is not defined!");
                        }
                    }
                    case LOGOUT -> {
                        return;
                    }
//                    case SETTINGS -> signup();
                    default -> System.out.println("invalid command");
                }
            }
            else System.out.println("invalid command");
        }
    }

    public void run(){
        while (!(input = scanner.nextLine()).equalsIgnoreCase("exit")&&!levelCompleted){
            Orders order = check(input);
            if (order != null) {
                switch (order) {
                    case BUY -> System.out.println(controller.buyDomestic(check(order, input).group(1)));
                    case PICKUP -> System.out.println(controller.pickup(check(order, input).group(1), check(order, input).group(2)));
                    case WELL -> System.out.println(controller.well());
                    case PLANT -> System.out.println(controller.plant(check(order, input).group(1), check(order, input).group(2)));
                    case WORK -> System.out.println(controller.work(check(order, input).group(1)));
                    case CAGE -> System.out.println(controller.cage(check(order, input).group(1), check(order, input).group(2)));
                    case TURN -> System.out.println(controller.turn(check(order, input).group(1)));
                    case TRUCK_LOAD -> System.out.println(controller.truckLoad(check(order, input).group(1)));
                    case TRUCK_UNLOAD -> System.out.println(controller.truckUnload(check(order, input).group(1)));
                    case TRUCK_GO -> controller.truckGO();
//                    case BUILD -> System.out.println(controller.truckGo());
                    default -> System.out.println("invalid command");
                }
            }
            else System.out.println("invalid command");
        }
    }

    private User login(){
        while (!input.equalsIgnoreCase("exit")&&!(input = scanner.nextLine()).equalsIgnoreCase("exit")){
            try{
                String username = check(Orders.USERNAME,input).group(1);
                if(!userController.checkUsername(username)){
                    while (!input.equalsIgnoreCase("exit")&&!(input = scanner.nextLine()).equalsIgnoreCase("exit")){
                        try{
                            if(userController.checkPassword(check(Orders.PASSWORD,input).group(1),username)){
                                menu();
                                return userController.getUser(username);
                            } else {
                                System.out.println("wrong password!\nEnter again");
                            }
                        }catch (NullPointerException e){
                            System.out.println("Invalid input type!\nset 'password' before your pass");
                        }
                    }
                } else {
                    System.out.println("Invalid username!\nEnter again");
                }
            }catch (NullPointerException e){
                System.out.println("Invalid input type!\nset 'username' before your username");
            }
        }
        return null;
    }

    private void signup(){
        while (!input.equalsIgnoreCase("exit")&&!(input = scanner.nextLine()).equalsIgnoreCase("exit")){
            try{
                String username = check(Orders.USERNAME,input).group(1);
                if(userController.checkUsername(username)){
                    while (!input.equalsIgnoreCase("exit")&&!(input = scanner.nextLine()).equalsIgnoreCase("exit")){
                        try {
                            userController.addUser(username,check(Orders.PASSWORD,input).group(1));
                            return;
                        }catch (NullPointerException e){
                            System.out.println("Invalid input type!\nset 'password' before your pass");
                        }
                    }
                } else {
                    System.out.println("Invalid username!\nEnter again");
                }
            }catch (NullPointerException e){
                System.out.println("Invalid input type!\nset 'username' before your username");
            }
        }
    }

    private Orders check(String str){
        for (Orders value : Orders.values()) {
            if(value.matching(str).matches())
                return value;
        }
        return null;
    }

    private Matcher check(Orders order,String str){
        Matcher matcher;
        if((matcher = order.matching(str)).matches())
            return matcher;
        return null;
    }

    private Mission getMission(int level){
        ArrayList<Mission> missions;
        try {
            missions = mapper.readValue(file,mapper.getTypeFactory().constructCollectionType(ArrayList.class, Mission.class));
            return missions.get(level-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
