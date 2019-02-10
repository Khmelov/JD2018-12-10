package by.it.yarmolenka.MathCalc;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

class Log {

    private static volatile Log log;
    private static String pathToLogFile;
    private static List<String> logList = new LinkedList<>();

    private Log() {
        pathToLogFile = GetPath.getPath(Log.class) + "log.txt";
    }

    public static Log getLog() {
        if (log == null)
            synchronized (Log.class) {
                if (log == null) log = new Log();
            }
        return log;
    }

    List<String> getLogList(){
        return logList;
    }

    synchronized void addToLog(String message) {
        logList.add(message);
        if (new File(pathToLogFile).exists()) {
            reWriteLast49ToFile();
        }
        Date date = new Date();
        message = String.format("%s %s", date, message);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToLogFile, true))) {
            writer.append(message).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reWriteLast49ToFile() {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader((new FileReader(pathToLogFile)))) {
            while (reader.ready()) list.add(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list.size() >= 50) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToLogFile))) {
                for (int i = list.size() - 49; i < list.size(); i++) {
                    writer.write(list.get(i) + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
