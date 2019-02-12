package by.it.dziomin.calculator;

import by.it.dziomin.calculator.logs.Logger;

public class CalcException extends Exception {

    private String msg;

    public CalcException(String message) {
        Logger logger = Logger.getInstance();
        logger.printToFile(Localizer.getBundle().getString(Localization.ERROR) + " " + message);
        this.msg = Localizer.getBundle().getString(Localization.ERROR) + message;
    }

    public String getMsg() {
        return msg;
    }

}
