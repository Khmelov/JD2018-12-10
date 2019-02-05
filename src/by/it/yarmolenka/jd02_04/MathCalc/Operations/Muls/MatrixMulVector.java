package by.it.yarmolenka.jd02_04.MathCalc.Operations.Muls;

import by.it.yarmolenka.jd02_04.MathCalc.CalcException;
import by.it.yarmolenka.jd02_04.MathCalc.Variables.Matrix;
import by.it.yarmolenka.jd02_04.MathCalc.Variables.Vector;

public class MatrixMulVector {
    public static Vector matrixVector(Matrix m, Vector v) throws CalcException {
        if (m.value[0].length == v.value.length){
            double[] res = new double[m.value.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j<m.value[0].length;j++){
                    res[i]+=m.value[i][j]*v.value[j];
                }
            }
            return new Vector(res);
        } else {
            throw new CalcException("Для умножения матрицы на вектор необходимо чтобы количество столбцов в матрице равнялось размеру вектора");
        }
    }
}
