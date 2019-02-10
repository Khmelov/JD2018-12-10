package by.it.moroz.calc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Report {

    private static String filename;
    private StringBuffer sb;

    Report() {
        filename = System.getProperty("user.dir") + "/src/by/it/moroz/calc/report.txt";
        sb = new StringBuffer();
    }

    void addTitle() {
        sb.append("REPORT!\n");
    }

    void addStartTime(String title) {
        sb.append(title);
    }

    void addExpression(String title) {
        sb.append(title);
    }

    void addResult(String title) {
        sb.append(title);
    }

    void addError(String title) {
        sb.append(title);
    }

    void addFinishTime(String title) {
        sb.append(title);
    }

    void getReport() {
        String message = String.format("%s\n", sb);
        synchronized (ReportBuilder.class) {
            try (
                    BufferedWriter out =
                            new BufferedWriter(
                                    new FileWriter(filename, true)
                            )
            ) {
                out.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
