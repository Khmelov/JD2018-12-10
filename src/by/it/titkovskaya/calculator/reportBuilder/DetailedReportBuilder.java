package by.it.titkovskaya.calculator.reportBuilder;

import by.it.titkovskaya.calculator.ConsoleRunner;
import by.it.titkovskaya.calculator.ResMan;
import by.it.titkovskaya.calculator.internationalization.strings.Service;

import java.util.LinkedList;

public class DetailedReportBuilder extends ReportBuilder {

    private static LinkedList<String> operationsAndErrorsInfo = new LinkedList<>();


    public void addInfo(String info) {
        operationsAndErrorsInfo.addLast(info);
    }

    @Override
    void buildOutputFileName() {
        report.setFileName(System.getProperty("user.dir") + "" +
                "/src/by/it/titkovskaya/calc/reportBuilder/DetailedReport.txt");
    }

    @Override
    void buildTitle() {
        report.setTitle(ResMan.INSTANCE.get(Service.DETAILED_REPORT));
    }

    @Override
    void buildStartTime() {
        report.setStartTime(ResMan.INSTANCE.get(Service.START_TIME) + " " + ConsoleRunner.timeStart.toString());
    }

    @Override
    void buildOperationsAndErrorsInfo() {
        StringBuilder infoBuilder = new StringBuilder();
        for (String info : operationsAndErrorsInfo) {
            infoBuilder.append(info).append("\n");
        }
        report.setOperationsAndErrorsInfo(infoBuilder.toString());
    }

    @Override
    void buildFinishTime() {
        report.setFinishTime(ResMan.INSTANCE.get(Service.FINISH_TIME) + " " + ConsoleRunner.timeFinish.toString());
    }


}
