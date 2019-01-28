package by.it.subach.jd01_09.CalcV3;

public class CalcException extends Exception {
    public CalcException() {
        super();
    }

    public CalcException(String message) {
//        super("ERROR: " + message);
        System.out.println("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
//        super("ERROR: " + message, cause);
        System.out.println("ERROR: " + message + cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }


}
