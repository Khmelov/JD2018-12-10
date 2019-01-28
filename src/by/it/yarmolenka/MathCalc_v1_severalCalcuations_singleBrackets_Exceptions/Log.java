package by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions;

import java.io.*;
import java.util.ArrayList;

class Log {

    private static String pathToLogFile = GetPath.getPath(Log.class) + "log.txt";


    static void addToLog(String message) {
        ArrayList<String> list = new ArrayList<>();
        String s;
        try (BufferedReader reader = new BufferedReader((new FileReader(pathToLogFile)))){
            while ((s = reader.readLine()) !=null) list.add(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list.size()>=50){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToLogFile))){
                for (int i = list.size() - 49; i < list.size(); i++) {
                    writer.write(list.get(i) + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToLogFile, true))){
            writer.append(message).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
