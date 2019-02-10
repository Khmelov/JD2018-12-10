package by.it.titkovskaya.calc;

import java.io.*;
import java.util.LinkedList;

class Log {

    private static LinkedList<String> logList = new LinkedList<>();

    private static String filename = System.getProperty("user.dir")+""+
            "/src/by/it/titkovskaya/calc/"+
            "log.txt";

    private Log(){
    }

    private static void loadLogFromFile() {
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

    static void toLog(String logLine){
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
