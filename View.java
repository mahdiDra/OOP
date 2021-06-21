import java.util.Scanner;
import java.util.regex.Matcher;

public class View {

    Controller controller;
    String input;
    Scanner scanner;

    public View() {
        this.controller = new Controller();
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        while (!(input = scanner.nextLine()).equals("exit")){
            Orders order = check(input);
            if (order != null) {
                switch (order) {
                    case BUY -> System.out.println(controller.buyDomestic(check(order, input).group(1)));
                    case PICKUP -> System.out.println(controller.pickup(check(order, input).group(1), check(order, input).group(2)));
                    case WELL -> System.out.println(controller.well);
                    case PLANT -> System.out.println(controller.plant(check(order, input).group(1), check(order, input).group(2)));
                    case WORK -> System.out.println(controller.work(check(order, input).group(1)));
                    case CAGE -> System.out.println(controller.cage(check(order, input).group(1), check(order, input).group(2)));
                    case TURN -> System.out.println(controller.turn(check(order, input).group(1)));
                    case TRUCK_LOAD -> System.out.println(controller.truckLoad(check(order, input).group(1)));
                    case TRUCK_UNLOAD -> System.out.println(controller.truckUnload(check(order, input).group(1)));
                    case TRUCK_GO -> System.out.println(controller.truckGo());
                }
            }
            else System.out.println("invalid command");
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









}
