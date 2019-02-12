package by.it.dziomin.calculator.logs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {

    private static final String fileName = System.getProperty("user.dir") + "\\src\\by\\it\\dziomin\\calculator\\logs\\log.txt";
    private static volatile Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (fileName) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void printToFile(String errorMessage) {
        Date date = new Date();
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            date.setTime(date.getTime());
            writer.write(date + "   " + errorMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
