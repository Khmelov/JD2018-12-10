package by.it.skosirskiy.Calc;

public class CalcException extends Exception {


    public CalcException() {
        super(ResMan.INSTANCE.get(Message.str4));
    }

    public CalcException(String message) {
        super(ResMan.INSTANCE.get(Message.str4)+message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResMan.INSTANCE.get(Message.str4)+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: "+message, cause, enableSuppression, writableStackTrace);
    }
}
