package by.it.yarmolenka.jd02_05.MathCalc.Operations;

import by.it.yarmolenka.jd02_05.MathCalc.CalcException;
import by.it.yarmolenka.jd02_05.MathCalc.Operations.Adds.*;
import by.it.yarmolenka.jd02_05.MathCalc.Patterns;
import by.it.yarmolenka.jd02_05.MathCalc.ResMan;
import by.it.yarmolenka.jd02_05.MathCalc.Strings.MathError;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Matrix;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Scalar;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Var;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Vector;

public class Add {
    public static Var addVarVar(Var var1, Var var2) throws CalcException {
        ResMan resMan = ResMan.INSTANCE;


        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.SCALAR)) {
            Scalar sc1 = new Scalar(var1.toString());
            Scalar sc2 = new Scalar(var2.toString());
            return ScalarAddScalar.scalarScalar(sc1, sc2);
        }

        if ((var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.SCALAR)) ||
                (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.VECTOR))) {
            Vector vec = new Vector(var1.toString().matches(Patterns.VECTOR)?var1.toString():var2.toString());
            Scalar sc = new Scalar(var1.toString().matches(Patterns.SCALAR)?var1.toString():var2.toString());
            return VectorAddScalar.vectorScalar(vec, sc);
        }

        if ((var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.SCALAR)) ||
                (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.MATRIX))) {
            Matrix mat = new Matrix(var1.toString().matches(Patterns.MATRIX)?var1.toString():var2.toString());
            Scalar sc = new Scalar(var1.toString().matches(Patterns.SCALAR)?var1.toString():var2.toString());
            return MatrixAddScalar.matrixScalar(mat, sc);
        }

        if ((var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.MATRIX)) ||
                (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.VECTOR))) {
            throw new CalcException(resMan.get(MathError.ADD), resMan);
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.VECTOR)) {
            Vector vec1 = new Vector(var1.toString());
            Vector vec2 = new Vector(var2.toString());
            return VectorAddVector.vectorVector(vec1, vec2, resMan);
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.MATRIX)) {
            Matrix mat1 = new Matrix(var1.toString());
            Matrix mat2 = new Matrix(var2.toString());
            return MatrixAddMatrix.matrixMatrix(mat1, mat2, resMan);
        }

        throw new CalcException(resMan.get(MathError.ADD), resMan);
    }

}
