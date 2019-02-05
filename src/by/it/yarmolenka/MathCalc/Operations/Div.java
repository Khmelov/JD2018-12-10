package by.it.yarmolenka.MathCalc.Operations;

import by.it.yarmolenka.MathCalc.CalcException;
import by.it.yarmolenka.MathCalc.Operations.Divs.*;
import by.it.yarmolenka.MathCalc.Patterns;
import by.it.yarmolenka.MathCalc.ResMan;
import by.it.yarmolenka.MathCalc.Strings.MathError;
import by.it.yarmolenka.MathCalc.Variables.*;

public class Div {

    public static Var divVarVar(Var var1, Var var2) throws CalcException {
        ResMan resMan = ResMan.INSTANCE;

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.SCALAR)) {
            Scalar sc1 = new Scalar(var1.toString());
            Scalar sc2 = new Scalar(var2.toString());
            return ScalarDivScalar.scalarScalar(sc1, sc2, resMan);
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.SCALAR)) {
            Vector vec = new Vector(var1.toString());
            Scalar sc = new Scalar(var2.toString());
            return VectorDivScalar.vectorScalar(vec, sc, resMan);
        }

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.VECTOR)) {
            throw new CalcException(resMan.get(MathError.DIV), resMan);
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.SCALAR)) {
            Matrix m = new Matrix(var1.toString());
            Scalar sc = new Scalar(var2.toString());
            return MatrixDivScalar.matrixScalar(m, sc, resMan);
        }

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.MATRIX)) {
            throw new CalcException(resMan.get(MathError.DIV), resMan);
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.MATRIX)) {
            throw new CalcException(resMan.get(MathError.DIV), resMan);
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.VECTOR)) {
            throw new CalcException(resMan.get(MathError.DIV), resMan);
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.VECTOR)) {
            throw new CalcException(resMan.get(MathError.DIV), resMan);
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.MATRIX)) {
            throw new CalcException(resMan.get(MathError.DIV), resMan);
        }

        throw new CalcException(resMan.get(MathError.DIV), resMan);
    }
}
