package by.it.naron.jd01_15.calc_V3_with_log_and_savevars;

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

    ;
}
