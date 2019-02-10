package by.it.yarmolenka.jd02_06;

import by.it.yarmolenka.MathCalc.GetPath;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {
    private static volatile Logger log;
    private String PATH;

    private Logger() {
        PATH = GetPath.getPath(Logger.class) + "log.txt";
    }

    public static Logger getLogger() {
        if (log == null)
            synchronized (Logger.class) {
                if (log == null) log = new Logger();
            }
        return log;
    }

    void logMessage(String message) {
        Date date = new Date();
        message = String.format("%s %s", date.toString(), message);
        synchronized (Logger.class) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(PATH, true))) {
                writer.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
