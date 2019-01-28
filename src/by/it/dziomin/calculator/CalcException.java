package by.it.dziomin.calculator;

public class CalcException extends Exception {

    private String msg;

    String getMsg() {
        return msg;
    }
    public CalcException(String message) {
        Logger.printToFile("ERROR:" + message);
        this.msg = "ERROR:" + message;
    }

}
