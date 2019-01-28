package by.it.naron.jd01_15.calc_V3_with_log_and_savevars;

public class CalcException extends Exception{

    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super("ERROR: "+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
