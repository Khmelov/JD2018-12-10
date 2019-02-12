package by.it.dziomin.calculator.vars;

import by.it.dziomin.calculator.CalcException;
import by.it.dziomin.calculator.Localization;
import by.it.dziomin.calculator.Localizer;

import java.util.Objects;

public class Scalar extends Var {

    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.getValue();
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public String toString() {
        return String.valueOf(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean isScalar() {
        return true;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other.isScalar()) {
            double result = this.value + ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other.isScalar()) {
            double result = this.value - ((Scalar) other).value;
            return new Scalar(result);
        }
        // other Vector or Matrix
        return other.add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other.isScalar()) {
            double result = this.value * ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other.isScalar()) {
            if (((Scalar) other).value==0){
                throw new CalcException(Localizer.getBundle().getString(Localization.DIVZERO_ERROR));
            }
            double result = this.value / ((Scalar) other).value;
            return new Scalar(result);
    }
        if (other.isVector()) {
            throw new CalcException(Localizer.getBundle().getString(Localization.DIV_ERROR));
        }
        return other.add(this);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scalar scalar = (Scalar) o;
        return Double.compare(scalar.getValue(), getValue()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
