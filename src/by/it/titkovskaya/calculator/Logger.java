package by.it.titkovskaya.calculator;

import java.io.*;
import java.util.LinkedList;

class Logger {

    private static LinkedList<String> logList = new LinkedList<>();

    private static volatile Logger instance;

    private String filename;

    private Logger() {
        filename = System.getProperty("user.dir")+""+
                "/src/by/it/titkovskaya/calc/log.txt";
    }

    static Logger getLogger() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    private void loadLogFromFile() {
        if (!new File(filename).exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            for (; ; ) {
                String s = reader.readLine();
                if (s == null)
                    return;
                else{
                    logList.addLast(s);
                    if (logList.size()>50)
                        logList.removeFirst();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void toLog(String logLine){
        loadLogFromFile();
        logList.addLast(logLine);
        if (logList.size()<=50){
            try (BufferedWriter out = new BufferedWriter(new FileWriter(filename,true))) {
                out.write(logLine+"\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            logList.removeFirst();
            try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
                for (String line : logList) {
                    out.write(line+"\n");
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
