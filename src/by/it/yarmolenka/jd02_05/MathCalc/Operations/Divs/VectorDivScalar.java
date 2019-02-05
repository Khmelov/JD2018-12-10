package by.it.yarmolenka.jd02_05.MathCalc.Operations.Divs;

import by.it.yarmolenka.jd02_05.MathCalc.CalcException;
import by.it.yarmolenka.jd02_05.MathCalc.ResMan;
import by.it.yarmolenka.jd02_05.MathCalc.Strings.MathError;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Scalar;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Vector;

import java.util.Arrays;

public class VectorDivScalar {
    public static Vector vectorScalar(Vector vec, Scalar sc, ResMan resMan) throws CalcException {
        if (sc.value == 0) throw new CalcException(resMan.get(MathError.DIV_BY_ZERO), resMan);
        else {
            double[] res = Arrays.copyOf(vec.value, vec.value.length);
            for (int i = 0; i < res.length; i++) res[i] /= sc.value;
            return new Vector(res);
        }
    }
}
