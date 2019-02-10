package by.it.yarmolenka.MathCalc.ReportCalc;

import by.it.yarmolenka.MathCalc.Translator;

import java.util.Date;
import java.util.List;

public abstract class ReportBuilder {
    Report report;

    Report getReport(){
        return this.report;
    }

    void createNewReport(){
        report = new Report();
    }

    public abstract void buildHeader(Translator translator);
    public abstract void buildTime(Date start, Date finish, Translator translator);
    public abstract void buildOperations(List<String> operationsList);
}
