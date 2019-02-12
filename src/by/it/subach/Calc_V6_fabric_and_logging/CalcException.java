package by.it.subach.Calc_V6_fabric_and_logging;

import by.it.subach.Calc_V6_fabric_and_logging.localization.TranslateManager;

public class CalcException extends Exception {
    public CalcException() {
        super();
    }

    TranslateManager tm = TranslateManager.INSTANCE;


    public CalcException(String message) {
        super ("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }


}
