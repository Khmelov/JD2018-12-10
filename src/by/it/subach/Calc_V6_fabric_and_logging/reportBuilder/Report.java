package by.it.subach.Calc_V6_fabric_and_logging.reportBuilder;

public interface Report {

    void printHeader();
    void printStartUseTime();
    void printEndUseTime();
    void printOperations(String operation, String result);
    void printExceptions(Exception exception);
    String getDate();
}
