package by.it.yarmolenka.jd02_04.MathCalc.Operations.Divs;

import by.it.yarmolenka.jd02_04.MathCalc.CalcException;
import by.it.yarmolenka.jd02_04.MathCalc.Variables.Scalar;
import by.it.yarmolenka.jd02_04.MathCalc.Variables.Vector;

import java.util.Arrays;

public class VectorDivScalar {
    public static Vector vectorScalar(Vector vec, Scalar sc) throws CalcException {
        if (sc.value == 0) throw new CalcException("Деление на ноль невозможно");
        else {
            double[] res = Arrays.copyOf(vec.value, vec.value.length);
            for (int i = 0; i < res.length; i++) res[i] /= sc.value;
            return new Vector(res);
        }
    }
}
