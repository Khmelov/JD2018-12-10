package by.it.yarmolenka.jd02_05.MathCalc;

import by.it.yarmolenka.jd02_05.MathCalc.Strings.MathError;

public class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message, ResMan resMan) {
        super(resMan.get(MathError.ERROR) + message);
    }

    public CalcException(String message, Throwable cause, ResMan resMan) {
        super(resMan.get(MathError.ERROR) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
