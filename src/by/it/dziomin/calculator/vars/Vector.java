package by.it.dziomin.calculator.vars;


import by.it.dziomin.calculator.CalcException;
import by.it.dziomin.calculator.Localization;
import by.it.dziomin.calculator.Localizer;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.getValue(), vector.getValue().length);
    }

    public Vector(String strVector) {
        Pattern pattern = Pattern.compile("[0-9.]+");
        Matcher matcher = pattern.matcher(strVector);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        this.value = new double[count];
        matcher = pattern.matcher(strVector);

        int i = 0;
        while (matcher.find()) {
            this.value[i] = Double.parseDouble(matcher.group());
            i++;
        }
    }

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

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    @Override
    public boolean isVector() {
        return true;
    }

    @Override
    public Var add(Var other) throws CalcException {

        if (other.isVector() && this.getValue().length == ((Vector) other).getValue().length) {
            double[] result = new double[this.getValue().length];
            for (int i = 0; i < result.length; i++) {
                result[i] = this.getValue()[i] + ((Vector) other).getValue()[i];
            }
            return new Vector(result);
        }

        if (other.isVector() && this.getValue().length != ((Vector) other).getValue().length){
            throw new CalcException(Localizer.getBundle().getString(Localization.ADD_ERROR));
        }

        if (other.isScalar()) {
            double[] result = new double[this.getValue().length];
            for (int i = 0; i < result.length; i++) {
                result[i] = this.getValue()[i] + ((Scalar) other).getValue();
            }
            return new Vector(result);
        }

        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other.isVector() && this.value.length == ((Vector) other).value.length) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = this.value[i] - ((Vector) other).value[i];
            }
            return new Vector(result);
        }

        if (other.isVector() && this.getValue().length != ((Vector) other).getValue().length){
            throw new CalcException(Localizer.getBundle().getString(Localization.SUB_ERROR));
        }

        if (other.isScalar()) {
            double[] result = new double[this.getValue().length];
            for (int i = 0; i < result.length; i++) {
                result[i] = this.getValue()[i] - ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other.isVector() && this.value.length == ((Vector) other).value.length) {
            double result = 0;
            for (int i = 0; i < this.value.length; i++) {
                result = this.value[i] * ((Vector) other).value[i] + result;
            }
            return new Scalar(result);
        }
        if (other.isScalar()) {
            double[] result = new double[this.getValue().length];
            for (int i = 0; i < result.length; i++) {
                result[i] = this.getValue()[i] * ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {

        if (other.isScalar()) {
            double[] result = new double[this.getValue().length];
            for (int i = 0; i < result.length; i++) {
                result[i] = this.getValue()[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        }

        return super.div(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Arrays.equals(getValue(), vector.getValue());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getValue());
    }
}
