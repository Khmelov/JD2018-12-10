package by.it.yarmolenka.MathCalc.Operations.Muls;

import by.it.yarmolenka.MathCalc.CalcException;
import by.it.yarmolenka.MathCalc.ResMan;
import by.it.yarmolenka.MathCalc.Strings.MathError;
import by.it.yarmolenka.MathCalc.Variables.*;

public class MatrixMulVector {
    public static Vector matrixVector(Matrix m, Vector v, ResMan resMan) throws CalcException {
        if (m.value[0].length == v.value.length){
            double[] res = new double[m.value.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j<m.value[0].length;j++){
                    res[i]+=m.value[i][j]*v.value[j];
                }
            }
            return new Vector(res);
        } else {
            throw new CalcException(resMan.get(MathError.MUL), resMan);
        }
    }
}
