package by.it.a_khmelev.calc_v4_with_multioperation_and_tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {

    private static String filename = System.getProperty("user.dir") + "" +
            "/src/by/it/a_khmelev/calc_v3_with_log_and_savevars/" +
            "log.txt";

    private Log() {
    }

    static void toLog(String logLine) {
        try (
                BufferedWriter out =
                        new BufferedWriter(
                                new FileWriter(filename, true)
                        )
        ) {
            out.write(logLine);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
