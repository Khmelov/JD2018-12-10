package by.it.subach.calc_V4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Log {

    // src/by/it/subach/calc_V4/log.txt
    private static String filename = System.getProperty("user.dir") + File.separator +
            "src" + File.separator + "by" + File.separator +
            "it" + File.separator + "subach" + File.separator +
            "calc_V4" + File.separator +"log.txt";

    private Log(){
    }

    static void toLog(String logLine){
        try(
                BufferedWriter out = new BufferedWriter(
                        new FileWriter(filename, true)
                )
        ) {
            out.write(logLine);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
