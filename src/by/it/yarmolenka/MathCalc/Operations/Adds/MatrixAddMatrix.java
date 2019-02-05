package by.it.yarmolenka.MathCalc.Operations.Adds;

import by.it.yarmolenka.MathCalc.CalcException;
import by.it.yarmolenka.MathCalc.ResMan;
import by.it.yarmolenka.MathCalc.Strings.MathError;
import by.it.yarmolenka.MathCalc.Variables.*;

public class MatrixAddMatrix {
    public static Matrix matrixMatrix(Matrix m1, Matrix m2, ResMan resMan) throws CalcException {
        if (m1.value.length == m2.value.length && m1.value[0].length == m2.value[0].length){
            double[][] res = new double[m1.value.length][m1.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = m1.value[i][j] + m2.value[i][j];
                }
            }
            return new Matrix(res);
        } else throw new CalcException(resMan.get(MathError.ADD), resMan);
    }
}
