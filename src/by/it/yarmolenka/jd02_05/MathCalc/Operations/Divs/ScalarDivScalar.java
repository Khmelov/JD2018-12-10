package by.it.yarmolenka.jd02_05.MathCalc.Operations.Divs;

import by.it.yarmolenka.jd02_05.MathCalc.CalcException;
import by.it.yarmolenka.jd02_05.MathCalc.ResMan;
import by.it.yarmolenka.jd02_05.MathCalc.Strings.MathError;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Scalar;

public class ScalarDivScalar {
    public static Scalar scalarScalar(Scalar sc1, Scalar sc2, ResMan resMan) throws CalcException {
        if (sc2.value == 0) throw new CalcException(resMan.get(MathError.DIV_BY_ZERO), resMan);
        else return new Scalar(sc1.value / sc2.value);
    }
}
