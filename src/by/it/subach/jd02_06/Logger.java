package by.it.subach.jd02_06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {

    private static volatile Logger instance;

    private final String FILENAME;

    private Logger() {
        FILENAME = System.getProperty("user.dir") + "/src/by/it/subach/jd02_06/log.txt";
    }

    public static Logger getLogger() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    void log(String text) {
        Date date = new Date();
        String message = String.format("%s %s\n", date.toString(), text);
        synchronized (Logger.class) {

            try (
                    BufferedWriter out =
                            new BufferedWriter(
                                    new FileWriter(FILENAME, true)
                            )
            ) {

                out.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
