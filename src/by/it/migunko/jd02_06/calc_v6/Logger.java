package by.it.migunko.jd02_06.calc_v6;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
public class Logger {
    private static Logger instance;
    private String path = System.getProperty("user.dir") + "/src/by/it/migunko/jd02_06/calc_v6/";
    private File logFile = new File(path, "log.txt");
    private DateFormat df = DateFormat.getDateTimeInstance(1,2);

    private Logger(){}

    static Logger getInstance(){
        if (instance == null){
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    void writeLog(String text){
        Date date = new Date();
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(logFile, true)
        )) {
            pw.printf("Время события: %s\n", df.format(date));
            pw.println(text);
            pw.print("--------------------------------------------\n");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
