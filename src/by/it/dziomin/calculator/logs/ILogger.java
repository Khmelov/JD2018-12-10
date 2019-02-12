package by.it.dziomin.calculator.logs;

public interface ILogger {

    String fileName = System.getProperty("user.dir") + "\\src\\by\\it\\dziomin\\calculator\\logs\\log.txt";

    void printToFile(String str);


}
