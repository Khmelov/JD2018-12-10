package by.it.moroz.calc;

abstract class ReportBuilder {
    Report report;

    void createNewReport() {
        report = new Report();
    }

    void getReport() {
        report.getReport();
    }

    abstract void getTitle();

    abstract void getStartTime();

    abstract void getExpression(String expression);

    abstract void getResult(String result);

    abstract void getError(CalcException calcException);

    abstract void getFinishTime();
}
