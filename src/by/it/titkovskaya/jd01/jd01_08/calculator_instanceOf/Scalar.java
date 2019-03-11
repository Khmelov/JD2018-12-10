package by.it.titkovskaya.jd01.jd01_08.calculator_instanceOf;

import java.util.Arrays;

public class Scalar extends Var {

    public double getValue() {
        return value;
    }

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    //============================ Addition =============================

    @Override
    public Var add(Var other) {
        return other.addCross(this);
    }

    @Override
    public Var addCross(Scalar other) {
        double result = this.value + other.value;
        return new Scalar(result);
    }

    @Override
    public Var addCross(Vector other) {
        return other.addCross(this);
    }

    @Override
    public Var addCross(Matrix other) {
        return other.addCross(this);
    }

    //============================ Subtraction =============================

    @Override
    public Var sub(Var other) {
        return other.subCross(this);
    }

    @Override
    public Var subCross(Scalar other) {
        double result = other.value - this.value;
        return new Scalar(result);
    }

    @Override
    public Var subCross(Vector other) {
        double[] res = Arrays.copyOf(other.getValue(), other.getValue().length);
        for (int i = 0; i < res.length; i++) {
            res[i] -= this.value;
        }
        return new Vector(res);
    }

    @Override
    public Var subCross(Matrix other) {
        Scalar minus = new Scalar(-1);
        return other.add(this.mulCross(minus));
    }

    //============================ Multiplication =============================

    @Override
    public Var mul(Var other) {
        return other.mulCross(this);
    }

    @Override
    public Var mulCross(Scalar other) {
        double result = this.value * other.value;
        return new Scalar(result);
    }

    @Override
    public Var mulCross(Vector other) {
        return other.mulCross(this);
    }

    @Override
    public Var mulCross(Matrix other) {
        return other.mulCross(this);
    }

    //============================ Division =============================

    @Override
    public Var div(Var other) {
        return other.divCross(this);
    }

    @Override
    public Var divCross(Scalar other) {
        double result = other.value / this.value;
        return new Scalar(result);
    }

    @Override
    public Var divCross(Vector other) {
        return other.divCross(this);
    }

    @Override
    public Var divCross(Matrix other) {
        return other.divCross(this);
    }

    //============================ toString =============================

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}