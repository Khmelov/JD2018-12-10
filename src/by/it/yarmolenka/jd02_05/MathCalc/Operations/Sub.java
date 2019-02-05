package by.it.yarmolenka.jd02_05.MathCalc.Operations;

import by.it.yarmolenka.jd02_05.MathCalc.CalcException;
import by.it.yarmolenka.jd02_05.MathCalc.Operations.Adds.*;
import by.it.yarmolenka.jd02_05.MathCalc.Operations.Muls.MatrixMulScalar;
import by.it.yarmolenka.jd02_05.MathCalc.Operations.Muls.ScalarMulScalar;
import by.it.yarmolenka.jd02_05.MathCalc.Operations.Muls.VectorMulScalar;
import by.it.yarmolenka.jd02_05.MathCalc.Patterns;
import by.it.yarmolenka.jd02_05.MathCalc.ResMan;
import by.it.yarmolenka.jd02_05.MathCalc.Strings.MathError;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Matrix;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Scalar;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Var;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Vector;

public class Sub {

    public static Var subVarVar(Var var1, Var var2) throws CalcException {

        ResMan resMan = ResMan.INSTANCE;
        Scalar min = new Scalar(-1);

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.SCALAR)) {
            Scalar sc1 = new Scalar(var1.toString());
            Scalar sc2 = new Scalar(var2.toString());
            return ScalarAddScalar.scalarScalar(sc1, ScalarMulScalar.scalarScalar(sc2, min));
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.SCALAR)) {
            Vector vec = new Vector(var1.toString());
            Scalar sc = new Scalar(var2.toString());
            return VectorAddScalar.vectorScalar(vec, ScalarMulScalar.scalarScalar(sc, min));
        }

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.VECTOR)) {
            Scalar sc = new Scalar(var1.toString());
            Vector vec = new Vector(var2.toString());
            return VectorAddScalar.vectorScalar(VectorMulScalar.vectorScalar(vec, min), sc);
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.SCALAR)) {
            Matrix m = new Matrix(var1.toString());
            Scalar sc = new Scalar(var2.toString());
            return MatrixAddScalar.matrixScalar(m, ScalarMulScalar.scalarScalar(sc, min));
        }

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.MATRIX)) {
            Matrix m = new Matrix(var2.toString());
            Scalar sc = new Scalar(var1.toString());
            return MatrixAddScalar.matrixScalar(MatrixMulScalar.matrixScalar(m, min), sc);
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.MATRIX)) {
            throw new CalcException(resMan.get(MathError.SUB), resMan);
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.VECTOR)) {
            throw new CalcException(resMan.get(MathError.SUB), resMan);
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.VECTOR)) {
            Vector v1 = new Vector(var1.toString());
            Vector v2 = new Vector(var2.toString());
            return VectorAddVector.vectorVector(v1, VectorMulScalar.vectorScalar(v2, min), resMan);
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.MATRIX)) {
            Matrix m1 = new Matrix(var1.toString());
            Matrix m2 = new Matrix(var2.toString());
            return MatrixAddMatrix.matrixMatrix(m1, MatrixMulScalar.matrixScalar(m2, min), resMan);
        }

        throw new CalcException(resMan.get(MathError.SUB), resMan);
    }

}
