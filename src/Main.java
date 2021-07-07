import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        view.userCheck();
//        ArrayList<Mission> missions = new ArrayList<>();
//        Mission mission = new Mission(1,
//                200,
//                50,
//                500,
//                5,
//                3,
//                2,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0);
//        Mission mission1 = new Mission(2,
//                300,
//                70,
//                1000,
//                10,
//                10,
//                10,
//                5,
//                5,
//                0,
//                0,
//                0,
//                0);
//        Mission mission2 = new Mission(3,
//                500,
//                100,
//                1500,
//                10,
//                10,
//                10,
//                10,
//                10,
//                5,
//                5,
//                0,
//                0);
//        Mission mission3 = new Mission(4,
//                1000,
//                200,
//                3000,
//                20,
//                20,
//                20,
//                20,
//                20,
//                10,
//                10,
//                5,
//                5);
//        Mission mission4 = new Mission(5,
//                5000,
//                500,
//                10000,
//                50,
//                50,
//                50,
//                30,
//                30,
//                30,
//                20,
//                20,
//                20);
//        missions.add(mission);
//        missions.add(mission1);
//        missions.add(mission2);
//        missions.add(mission3);
//        missions.add(mission4);
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("missions.txt"),missions);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}