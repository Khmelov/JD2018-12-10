package by.it.zagurskaya.calc;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public static final VarCreator varCreator = VarCreator.getInstance();

    public Vector(String strVector) {
        String[] strings = strVector.replace("{", "").replace("}", "").split(",");
        this.value = new double[strings.length];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Double.parseDouble(strings[i]);
        }
    }

    public double[] getValue() {
        return Arrays.copyOf(this.value, this.value.length);
    }

    public Integer getLenght() {
        return this.value.length;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = ((Scalar) other).getValue() + res[i];
            }
            return varCreator.create(varCreator.toString(res));//new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    // double b=res[i];
                    res[i] += ((Vector) other).value[i];
                }
                return varCreator.create(varCreator.toString(res));//new Vector(res);
            }
        } else if ((other instanceof Matrix)) {
            String message = LocalMessages.ADDITION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
            throw new CalcException(message);//addition impossible
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return varCreator.create(varCreator.toString(res));//new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] -= ((Vector) other).value[i];
                }
                return varCreator.create(varCreator.toString(res));//new Vector(res);
            }
        } else if ((other instanceof Matrix)) {
            String message = LocalMessages.SUBTRACTION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
            throw new CalcException(message);//subtraction impossible
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
            return varCreator.create(varCreator.toString(res));//new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(this.value, this.value.length);
                double vectorMultVector = 0;
                for (int i = 0; i < res.length; i++) {
                    vectorMultVector += ((Vector) other).value[i] * res[i];
                }
                return varCreator.create(String.valueOf(vectorMultVector));//new Vector(res);
        }
        } else if ((other instanceof Matrix)) {
            String message = LocalMessages.MULTIPLICATION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
            throw new CalcException(message);//multiplication impossible
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
            return varCreator.create(varCreator.toString(res));//new Vector(res);
        } else if ((other instanceof Vector)) {
            String message = LocalMessages.DIVISION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
            throw new CalcException(message); //division impossible

        } else if ((other instanceof Matrix)) {
            String message = LocalMessages.DIVISION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
            throw new CalcException(message);//division impossible
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
