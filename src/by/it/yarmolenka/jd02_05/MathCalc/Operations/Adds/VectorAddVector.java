package by.it.yarmolenka.jd02_05.MathCalc.Operations.Adds;

import by.it.yarmolenka.jd02_05.MathCalc.CalcException;
import by.it.yarmolenka.jd02_05.MathCalc.ResMan;
import by.it.yarmolenka.jd02_05.MathCalc.Strings.MathError;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Vector;

public class VectorAddVector {
    public static Vector vectorVector(Vector v1, Vector v2, ResMan resMan) throws CalcException {
        if (v1.value.length == v2.value.length) {
            double[] res = new double[v1.value.length];
            for (int i = 0; i < res.length; i++)
                res[i] += v1.value[i] + v2.value[i];
            return new Vector(res);
        } else throw new CalcException(resMan.get(MathError.ADD), resMan);
    }
}
