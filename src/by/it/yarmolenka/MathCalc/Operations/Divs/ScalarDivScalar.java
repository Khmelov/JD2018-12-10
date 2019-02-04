package by.it.yarmolenka.MathCalc.Operations.Divs;

import by.it.yarmolenka.MathCalc.CalcException;
import by.it.yarmolenka.MathCalc.Variables.Scalar;

public class ScalarDivScalar {
    public static Scalar scalarScalar(Scalar sc1, Scalar sc2) throws CalcException {
        if (sc2.value == 0) throw new CalcException("Деление на ноль невозможно");
        else return new Scalar(sc1.value / sc2.value);
    }
}
