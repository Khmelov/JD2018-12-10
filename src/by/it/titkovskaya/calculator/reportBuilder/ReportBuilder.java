package by.it.titkovskaya.calculator.reportBuilder;

abstract class ReportBuilder {

    Report report;

    void creatReport(){
        report = new Report();
    }

    abstract void buildOutputFileName();
    abstract void buildTitle();
    abstract void buildStartTime();
    abstract void buildOperationsAndErrorsInfo();
    abstract void buildFinishTime();

    Report getReport(){
        return report;
    }

}
