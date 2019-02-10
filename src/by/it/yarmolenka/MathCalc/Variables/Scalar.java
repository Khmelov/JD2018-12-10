package by.it.yarmolenka.MathCalc.Variables;

import by.it.yarmolenka.MathCalc.CalcException;
import by.it.yarmolenka.MathCalc.Strings.MathError;
import by.it.yarmolenka.MathCalc.Translator;

import java.util.Arrays;

public class Scalar extends Var {

    static final Scalar MINUS = new Scalar(-1);
    private static Translator translator = Translator.INSTANCE;

    public double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String s) {
        this.value = Double.parseDouble(s);
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        return other.add2(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return other.sub2(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return other.mul2(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return other.div2(this);
    }

    public Var add2(Scalar scalar) {
        return new Scalar(this.value + scalar.getValue());
    }

    public Var add2(Vector vector) {
        double[] res = Arrays.copyOf(vector.value, vector.value.length);
        for (int i = 0; i < res.length; i++) {
            res[i] += this.value;
        }
        return new Vector(res);
    }

    public Var add2(Matrix matrix) {
        double[][] res = Arrays.copyOf(matrix.value, matrix.value.length);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] += this.value;
            }
        }
        return new Matrix(res);
    }

    public Var sub2(Scalar scalar) throws CalcException {
        return scalar.add(this.mul(MINUS));
    }

    public Var sub2(Vector vector) throws CalcException {
        return vector.add(this.mul(MINUS));
    }

    public Var sub2(Matrix matrix) throws CalcException {
        return matrix.add(this.mul(MINUS));
    }

    public Var mul2(Scalar scalar) {
        return new Scalar(scalar.getValue() * this.value);
    }

    public Var mul2(Vector vector) {
        double[] res = Arrays.copyOf(vector.value, vector.value.length);
        for (int i = 0; i < res.length; i++)
            res[i] *= this.value;
        return new Vector(res);
    }

    public Var mul2(Matrix matrix) {
        double[][] res = Arrays.copyOf(matrix.value, matrix.value.length);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++)
                res[i][j]*=this.value;
        }
        return new Matrix(res);
    }

    public Var div2(Scalar scalar) throws CalcException {
        if (this.value == 0)
            throw new CalcException(translator.get(MathError.DIV_BY_ZERO), translator);
        return new Scalar(scalar.getValue() / this.value);
    }

    public Var div2(Vector vector) throws CalcException {
        if (this.value == 0)
            throw new CalcException(translator.get(MathError.DIV_BY_ZERO), translator);
        double[] res = Arrays.copyOf(vector.value, vector.value.length);
        for (int i = 0; i < res.length; i++)
            res[i] /= this.value;
        return new Vector(res);
    }

    public Var div2(Matrix matrix) throws CalcException {
        if (this.value == 0)
            throw new CalcException(translator.get(MathError.DIV_BY_ZERO), translator);
        double[][] res = Arrays.copyOf(matrix.value, matrix.value.length);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++)
                res[i][j] /= this.value;
        }
        return new Matrix(res);
    }

    @Override
    public String toString() {
        return Double.toString(this.value);
    }
}
