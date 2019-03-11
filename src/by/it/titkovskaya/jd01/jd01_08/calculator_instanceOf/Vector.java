package by.it.titkovskaya.jd01.jd01_08.calculator_instanceOf;

import java.util.Arrays;

public class Vector extends Var {

    public double[] getValue() {
        return value;
    }

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    Vector(String strVector) {
        String[] otherVector = strVector.replaceAll("[^.,0-9]", "").split(",");
        this.value = new double[otherVector.length];
        for (int i = 0; i < otherVector.length; i++) {
            value[i] = Double.parseDouble(otherVector[i]);
        }
    }

    //============================ Addition =============================

    @Override
    public Var add(Var other) {
        return other.addCross(this);
    }

    @Override
    public Var addCross(Scalar other) {
        double[] res = Arrays.copyOf(this.value, this.value.length);
        for (int i = 0; i < res.length; i++) {
            res[i] += other.getValue();
        }
        return new Vector(res);
    }

    @Override
    public Var addCross(Vector other) {
        if (this.value.length == other.value.length) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += other.value[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var addCross(Matrix other) {
        return super.addCross(other);
    }

    //============================ Subtraction =============================

    @Override
    public Var sub(Var other) {
        return other.subCross(this);
    }

    @Override
    public Var subCross(Scalar other) {
        double[] res = Arrays.copyOf(this.value, this.value.length);
        for (int i = 0; i < res.length; i++) {
            res[i] -= other.getValue();
        }
        return new Vector(res);
    }

    @Override
    public Var subCross(Vector other) {
        if (this.value.length == other.value.length) {
            double[] res = Arrays.copyOf(other.value, other.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= this.value[i];
            }
            return new Vector(res);
        }
        return super.sub(other);
    }

    @Override
    public Var subCross(Matrix other) {
        return super.subCross(other);
    }

    //============================ Multiplication =============================

    @Override
    public Var mul(Var other) {
        return other.mulCross(this);
    }

    @Override
    public Var mulCross(Scalar other) {
        double[] res = Arrays.copyOf(this.value, this.value.length);
        for (int i = 0; i < res.length; i++) {
            res[i] *= other.getValue();
        }
        return new Vector(res);
    }

    @Override
    public Var mulCross(Vector other) {
        if (this.value.length == other.value.length) {
            double[] res = Arrays.copyOf(other.value, other.value.length);
            double mulResult = 0;
            for (int i = 0; i < res.length; i++) {
                res[i] *= this.value[i];
                mulResult += res[i];
            }
            return new Scalar(mulResult);
        }
        return super.mul(other);
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
        double[] res = Arrays.copyOf(this.value, this.value.length);
        for (int i = 0; i < res.length; i++) {
            res[i] /= other.getValue();
        }
        return new Vector(res);
    }

    @Override
    public Var divCross(Vector other) {
        return super.divCross(other);
    }

    @Override
    public Var divCross(Matrix other) {
        return super.divCross(other);
    }

    //============================ toString =============================

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");

        String delimiter = "";
        for (double v : value) {
            out.append(delimiter).append(v);
            delimiter = ", ";
        }
        out.append('}');
        return out.toString();
    }
}


/*
    public Var add(Var other) {
        if (other instanceof Scalar) {

        } else if (other instanceof Vector) {

        }

    }

 */