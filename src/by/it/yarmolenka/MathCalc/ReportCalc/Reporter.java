package by.it.yarmolenka.MathCalc.ReportCalc;

import by.it.yarmolenka.MathCalc.Translator;

import java.util.Date;
import java.util.List;

public class Reporter {
    private ReportBuilder reportBuilder;

    public void setReportBuilder(ReportBuilder reportBuilder){
        this.reportBuilder = reportBuilder;
    }

    public Report getReport(){
        return reportBuilder.getReport();
    }

    public void constructReport(Date start, Date finish, List<String> operationsList, Translator translator){
        reportBuilder.createNewReport();
        reportBuilder.buildHeader(translator);
        reportBuilder.buildTime(start, finish, translator);
        reportBuilder.buildOperations(operationsList);
    }
}
