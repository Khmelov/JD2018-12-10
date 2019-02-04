package by.it.yarmolenka.MathCalc.Operations.Divs;

import by.it.yarmolenka.MathCalc.CalcException;
import by.it.yarmolenka.MathCalc.Variables.*;

import java.util.Arrays;

public class MatrixDivScalar {
    public static Matrix matrixScalar(Matrix m, Scalar sc) throws CalcException {
        if (sc.value == 0) throw new CalcException("Деление на ноль невозможно");
        else {
            double[][] res = new double[m.value.length][m.value[0].length];
            for (int i = 0; i < res.length; i++) res[i] = Arrays.copyOf(m.value[i], m.value[i].length);
            for (int i = 0; i < res.length; i++)
                for (int j = 0; j < res[0].length; j++)
                    res[i][j] /= sc.value;
            return new Matrix(res);
        }
    }
}
