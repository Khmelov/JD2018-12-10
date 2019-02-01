package by.it.a_khmelev.calc_v4_with_multioperation_and_tests;


import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String str) {
        String[] val = str.replace("{", "").replace("}", "").split(",\\s*");
        value = new double[val.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(val[i]);
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
        }
        else if (other instanceof Vector) {
            if (this.value.length==((Vector) other).value.length) {
                double[] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i]+=((Vector) other).value[i];
                }
                return new Vector(res);
            }
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
        }
        else if (other instanceof Vector) {
            if (this.value.length==((Vector) other).value.length) {
                double[] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i]-=((Vector) other).value[i];
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
                res[i] *= ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            if (this.value.length==((Vector) other).value.length) {
                double res = 0;
                for (int i = 0; i < this.value.length; i++) {
                    res+=this.value[i]*((Vector) other).value[i];
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
