package by.it.subach.jd01_09.CalcV3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static String filename = System.getProperty("user.dir") + "\\src\\by\\it\\subach\\jd01_09\\CalcV3" + "log.txt";


    private Log(){

    }

    static void toLog(String logLine){
        try(BufferedWriter out = new BufferedWriter(new FileWriter(filename))){
            out.write(logLine);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
