package by.it.titkovskaya.calculator.reportBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Report {

    private String outputFileName;
    private String title;
    private String startTime;
    private String operationsAndErrorsInfo;
    private String finishTime;

    public void setFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    void setOperationsAndErrorsInfo(String operationsAndErrorsInfo) {
        this.operationsAndErrorsInfo = operationsAndErrorsInfo;
    }

    void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public void printReport(Report report) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName))) {
            out.write(report.toString());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "\t\t" + title + "\n\n"
                + startTime + "\n\n"
                + operationsAndErrorsInfo + "\n"
                + finishTime + "\n";
    }
}
