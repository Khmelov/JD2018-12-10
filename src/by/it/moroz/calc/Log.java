package by.it.moroz.calc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Log {

    private static volatile Log instance;

    private static String filename;

    private Log() {
        filename = System.getProperty("user.dir") +
                "/src/by/it/moroz/calc/errors.txt";
    }

    static Log getLogger() {
        if(instance==null){
            synchronized (Log.class){
                if (instance==null)
                    instance = new Log();
            }
        }
        return instance;
    }

    void toLog(String logLine) {
        Date date = new Date();
        String message = String
                .format("%s %s\n", date.toString(), logLine);
        synchronized (Log.class) {
            try (
                    BufferedWriter out =
                            new BufferedWriter(
                                    new FileWriter(filename, true)
                            )
            ) {
                out.write(message);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
