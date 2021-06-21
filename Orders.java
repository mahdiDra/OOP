import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Orders {

    BUY("(?i)^buy\\s+(\\w+)\\s*$"),
    PICKUP("(?i)^pickup\\s+(\\d+)\\s+(\\d+)\\s*$"),
    WELL("(?i)^well\\s*$"),
    PLANT("(?i)^plant\\s+(\\d+)\\s+(\\d+)\\s*$"),
    WORK("(?i)^work\\s+(\\w+)\\s*$"),
    CAGE("(?i)^cage\\s+(\\d+)\\s+(\\d+)\\s*$"),
    TURN("(?i)^turn\\s+(\\d+)\\s*$"),
    TRUCK_LOAD("(?i)^truck\\s*load\\s+(\\w+)\\s*$"),
    TRUCK_UNLOAD("(?i)^truck\\s*unload\\s+(\\w+)\\s*$"),
    TRUCK_GO("(?i)^truck\\s*go\\s*$"),
    ;

    Pattern pattern ;
    Orders(String input) {
        pattern = Pattern.compile(input);
    }
    Matcher matching(String output){
        return pattern.matcher(output);
    }

}
