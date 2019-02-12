package by.it.titkovskaya.calculator;

import by.it.titkovskaya.calculator.internationalization.strings.Programme;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    Vector(String strVector) {
        String[] otherVector = strVector.replace("{", "")
                                .replace("}", "").split(",\\s*");
        this.value = new double[otherVector.length];
        for (int i = 0; i < otherVector.length; i++) {
            value[i] = Double.parseDouble(otherVector[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException(ResMan.INSTANCE.get(Programme.ERROR_VECTOR_ADD));
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException(ResMan.INSTANCE.get(Programme.ERROR_VECTOR_SUB));
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] *= ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length != ((Vector) other).value.length) {
                throw new CalcException(ResMan.INSTANCE.get(Programme.ERROR_VECTOR_MUL));
            }
            double[] res = Arrays.copyOf(this.value, this.value.length);
            double mulResult = 0;
            for (int i = 0; i < res.length; i++) {
                res[i] *= ((Vector) other).value[i];
                mulResult += res[i];
            }
            return new Scalar(mulResult);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue()==0)
                throw new CalcException(ResMan.INSTANCE.get(Programme.ERROR_DIV_ZERO));
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] /= ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        return super.div(other);
    }

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
