package by.it.subach.calc_V4;

public class CalcException extends Exception {
    public CalcException() {
        super();
    }

    public CalcException(String message) {
//        super("ERROR: " + message);
        super ("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
//        super("ERROR: " + message, cause);
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }


}
