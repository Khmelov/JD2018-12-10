package by.it.titkovskaya.calculator.reportBuilder;

public class Reporter {

    private ReportBuilder builder;

    public void setBuilder(ReportBuilder builder) {
        this.builder = builder;
    }

    public Report buildReport(){
        builder.creatReport();
        builder.buildOutputFileName();
        builder.buildTitle();
        builder.buildStartTime();
        builder.buildOperationsAndErrorsInfo();
        builder.buildFinishTime();
        return builder.getReport();
    }
}
