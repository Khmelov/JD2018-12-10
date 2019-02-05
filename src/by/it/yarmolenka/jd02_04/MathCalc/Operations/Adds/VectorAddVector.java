package by.it.yarmolenka.jd02_04.MathCalc.Operations.Adds;

import by.it.yarmolenka.jd02_04.MathCalc.CalcException;
import by.it.yarmolenka.jd02_04.MathCalc.Variables.Vector;

public class VectorAddVector {
    public static Vector vectorVector(Vector v1, Vector v2) throws CalcException {
        if (v1.value.length == v2.value.length) {
            double[] res = new double[v1.value.length];
            for (int i = 0; i < res.length; i++)
                res[i] += v1.value[i] + v2.value[i];
            return new Vector(res);
        } else throw new CalcException("Для сложения/вычитания векторов они должны быть одного размера");
    }
}
