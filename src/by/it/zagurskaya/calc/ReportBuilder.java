package by.it.zagurskaya.calc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportBuilder {

    public static final String HEADER = "       Отчет об операциях в учебном проекте";
    public static final String ERROR = "ERROR:";
    private String FILENAMESHORT = System.getProperty("user.dir") + "/src/by/it/zagurskaya/calc/reportshort_"
            + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")) + ".txt";
    private String FILENAMFULL = System.getProperty("user.dir") + "/src/by/it/zagurskaya/calc/reportfull_"
            + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")) + ".txt";

    private List<String> messageList = new ArrayList<>();

    public ReportBuilder setHeader() {
        return saveMessage(HEADER);
    }

    public ReportBuilder saveMessage(String message) {
        messageList.add(message + "\n");
        return this;
    }

    public ReportBuilder saveTimeStamp() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        return saveMessage(df.format(new Date()));
    }

    public void build() {
        try (BufferedWriter outShortWriter = new BufferedWriter(new FileWriter(FILENAMESHORT, true));
             BufferedWriter outFullWriter = new BufferedWriter(new FileWriter(FILENAMFULL, true))) {
            for (String message : messageList) {
                if (message.startsWith(ERROR)) {
                    outShortWriter.write(ERROR + "\n");
                    outFullWriter.write(message.replaceFirst(ERROR, ""));
                } else {
                    outShortWriter.write(message);
                    outFullWriter.write(message);
                }
            }
        } catch (IOException | StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
