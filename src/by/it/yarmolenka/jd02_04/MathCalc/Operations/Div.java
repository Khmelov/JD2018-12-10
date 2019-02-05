package by.it.yarmolenka.jd02_04.MathCalc.Operations;

import by.it.yarmolenka.jd02_04.MathCalc.CalcException;
import by.it.yarmolenka.jd02_04.MathCalc.Operations.Divs.MatrixDivScalar;
import by.it.yarmolenka.jd02_04.MathCalc.Operations.Divs.ScalarDivScalar;
import by.it.yarmolenka.jd02_04.MathCalc.Operations.Divs.VectorDivScalar;
import by.it.yarmolenka.jd02_04.MathCalc.Patterns;
import by.it.yarmolenka.jd02_04.MathCalc.Variables.Matrix;
import by.it.yarmolenka.jd02_04.MathCalc.Variables.Scalar;
import by.it.yarmolenka.jd02_04.MathCalc.Variables.Var;
import by.it.yarmolenka.jd02_04.MathCalc.Variables.Vector;

public class Div {

    public static Var divVarVar(Var var1, Var var2) throws CalcException {

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.SCALAR)) {
            Scalar sc1 = new Scalar(var1.toString());
            Scalar sc2 = new Scalar(var2.toString());
            return ScalarDivScalar.scalarScalar(sc1, sc2);
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.SCALAR)) {
            Vector vec = new Vector(var1.toString());
            Scalar sc = new Scalar(var2.toString());
            return VectorDivScalar.vectorScalar(vec, sc);
        }

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.VECTOR)) {
            throw new CalcException("деление скаляра на вектор невозможно");
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.SCALAR)) {
            Matrix m = new Matrix(var1.toString());
            Scalar sc = new Scalar(var2.toString());
            return MatrixDivScalar.matrixScalar(m, sc);
        }

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.MATRIX)) {
            throw new CalcException("деление скаляра на матрицу невозможно");
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.MATRIX)) {
            throw new CalcException("деление вектора на матрицу невозможно");
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.VECTOR)) {
            throw new CalcException("деление матрицы на вектор невозможно");
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.VECTOR)) {
            throw new CalcException("деление вектора на вектор невозможно");
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.MATRIX)) {
            throw new CalcException("деление матрицы на матрицу невозможно");
        }

        throw new CalcException("не умею такое делить");
    }
}
