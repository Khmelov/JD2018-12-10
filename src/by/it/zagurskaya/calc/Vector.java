package by.it.zagurskaya.calc;


import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        //double[]value = Arrays.copyOf(this.value,this.value.length);
//        return value;
        return Arrays.copyOf(this.value, this.value.length);
    }
    public Integer getLenght() {
        return  this.value.length;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
//        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    public Vector(Vector otherVector) {
        this.value = new double[otherVector.value.length];
        System.arraycopy(otherVector.value, 0, value, 0, value.length);
    }


    public Vector(String strVector) {
        String[] strings = strVector.replace("{", "").replace("}", "").split(",");
        this.value = new double[strings.length];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Double.parseDouble(strings[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = ((Scalar) other).getValue() + res[i];
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    // double b=res[i];
                    res[i] += ((Vector) other).value[i];
                }
                return new Vector(res);
            }
        } else if ((other instanceof Matrix)) {
            throw new CalcException(LocalMessages.ADDITION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get());//addition impossible
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
            return new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    // double b=res[i];
                    res[i] -= ((Vector) other).value[i];
                }
                return new Vector(res);
            }
        } else if ((other instanceof Matrix)) {
            throw new CalcException(LocalMessages.SUBTRACTION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get());//subtraction impossible
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
                double[] res = Arrays.copyOf(this.value, this.value.length);
                double vectorMultVector = 0;
                for (int i = 0; i < res.length; i++) {
                    vectorMultVector += ((Vector) other).value[i] * res[i];
                }
                return new Scalar(vectorMultVector);
            }
        } else if ((other instanceof Matrix)) {
            throw new CalcException(LocalMessages.MULTIPLICATION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get());//multiplication impossible
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
        } else if ((other instanceof Vector)) {
//            throw new CalcException("Деление не возможно"); //division impossible
            throw new CalcException(LocalMessages.DIVISION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get()); //division impossible

        } else if ((other instanceof Matrix)) {
            throw new CalcException(LocalMessages.DIVISION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get());//division impossible
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
