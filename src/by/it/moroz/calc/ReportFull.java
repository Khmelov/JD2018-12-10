package by.it.moroz.calc;

import java.text.DateFormat;
import java.util.Date;

public class ReportFull extends ReportBuilder {

    void getTitle() {
        report.addTitle();
    }

    void getStartTime() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        Date currentDate = new Date();
        report.addStartTime("Program started in " + df.format(currentDate) + "\n");
    }

    void getExpression(String expression) {
        report.addExpression(expression + "\n");
    }

    void getResult(String result) {
        report.addResult(result + "\n");
    }

    void getError(CalcException calcException) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        Date currentDate = new Date();
        report.addError(df.format(currentDate) + " " + calcException.getClass().getSimpleName() + " "
                + calcException.getMessage() + "\n");
    }

    void getFinishTime() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        Date currentDate = new Date();
        report.addFinishTime("Program finished in " + df.format(currentDate) + "\n");
    }

}
