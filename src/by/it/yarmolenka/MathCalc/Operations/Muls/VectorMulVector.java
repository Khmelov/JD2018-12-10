package by.it.yarmolenka.MathCalc.Operations.Muls;

import by.it.yarmolenka.MathCalc.CalcException;
import by.it.yarmolenka.MathCalc.ResMan;
import by.it.yarmolenka.MathCalc.Strings.MathError;
import by.it.yarmolenka.MathCalc.Variables.*;

public class VectorMulVector {
    public static Scalar vectorVector(Vector vec1, Vector vec2, ResMan resMan) throws CalcException {
        if (vec1.value.length == vec2.value.length) {
            double res = 0;
            for (int i = 0; i < vec1.value.length; i++) {
                res += vec1.value[i] * vec2.value[i];
            }
            return new Scalar(res);
        } else{
            throw new CalcException(resMan.get(MathError.MUL), resMan);
        }
    }
}
