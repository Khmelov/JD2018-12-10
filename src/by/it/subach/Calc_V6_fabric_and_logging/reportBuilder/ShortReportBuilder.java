package by.it.subach.Calc_V6_fabric_and_logging.reportBuilder;

import by.it.subach.Calc_V6_fabric_and_logging.Logger;

public class ShortReportBuilder extends ReportBuilder {

    private Logger logger = Logger.getLogger();

    @Override
    public void printHeader() {
        logger.log("----------------------------------SHORT REPORT-----------------------------------");
    }

    @Override
    public void printExceptions(Exception exception) {
        String text = exception.getMessage();
//        String message = String.format("%s %s\n", text);
        logger.log(text + "\n");
    }
}
