package by.it.yarmolenka.jd02_05.MathCalc;

import java.io.*;
import java.util.ArrayList;

class Log {

    private static String pathToLogFile = GetPath.getPath(Log.class) + "log.txt";


    static void addToLog(String message) {
        ArrayList<String> list = new ArrayList<>();
        if (new File(pathToLogFile).exists()) {
            reWriteLast49ToFile(list);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToLogFile, true))) {
            writer.append(message).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reWriteLast49ToFile(ArrayList<String> list) {
        String s;
        try (BufferedReader reader = new BufferedReader((new FileReader(pathToLogFile)))) {
            while ((s = reader.readLine()) != null) list.add(s);
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
