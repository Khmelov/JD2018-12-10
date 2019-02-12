package by.it.subach.Calc_V6_fabric_and_logging.reportBuilder;

import by.it.subach.Calc_V6_fabric_and_logging.Logger;

public class LongReportBuilder extends ReportBuilder {

    private Logger logger = Logger.getLogger();

    @Override
    public void printHeader() {
        logger.log("-----------------------LONG REPORT------------------------------");
    }

    @Override
    public void printExceptions(Exception exception) {
        String err = exception.getMessage();

        StringBuilder sb = new StringBuilder(err);
        StackTraceElement[] stackTrace = exception.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            sb.append("\n").append(element);
        }

        String message = String.format("%s %s\n", getDate(), sb.toString());
        logger.log(message);

    }
}
