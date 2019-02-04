package by.it.moroz.calc;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    protected double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        String[] d = strVector.replaceAll("\\{", "").replaceAll("}", "").split(",");
        this.value = new double[d.length];
        for (int i = 0; i < d.length; i++) {
            value[i] = Double.parseDouble(d[i]);
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
            if (this.value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] += ((Vector) other).value[i];
                }
                return new Vector(res);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar minus = new Scalar(-1);
            /*double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+minus;
            }*/
            return this.add(other.mul(minus));
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] - ((Vector) other).value[i];
                }
                return new Vector(res);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double res = 0;
                for (int i = 0; i < this.value.length; i++) {
                    res += (this.value[i] * ((Vector) other).value[i]);
                }
                return new Scalar(res);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
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
        out.append("}");
        return out.toString();
    }
}
