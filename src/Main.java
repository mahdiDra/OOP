import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
public class Main {
    public static void main(String[] args) {



        java.util.logging.Logger logger;
        logger = java.util.logging.Logger.getLogger("MyLog");
        setLogger(logger);

        View view = new View();
        view.userCheck();


    }
    private static void setLogger(java.util.logging.Logger logger){
        FileHandler fileHandler;
        try{
            fileHandler = new FileHandler("Logfile.log");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.setUseParentHandlers(false);
        } catch (SecurityException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
