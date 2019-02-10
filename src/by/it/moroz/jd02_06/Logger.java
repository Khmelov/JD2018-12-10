package by.it.moroz.jd02_06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {

    private static volatile Logger instance;

    private String filename;

    private Logger(){
        filename=System.getProperty("user.dir") + "/src/by/it/moroz/jd02_06/log.txt";
    }

    static Logger getLogger() {
        if(instance==null){
            synchronized (Logger.class){
                if (instance==null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    public void log(String s) {
        Date date = new Date();
        String message = String
                .format("%s %s\n", date.toString(), s);
        synchronized (Logger.class) {
            try (
                    BufferedWriter out =
                            new BufferedWriter(
                                    new FileWriter(filename, true)
                            )
            ) {
                out.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
