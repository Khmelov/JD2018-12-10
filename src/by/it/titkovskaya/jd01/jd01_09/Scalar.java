package by.it.titkovskaya.jd01.jd01_09;

public class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double result = this.value+((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);
        // other Vector or Matrix
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double result = this.value-((Scalar) other).value;
            return new Scalar(result);
        }
        Scalar minus = new Scalar(-1);
        return other.add(this.mul(minus));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double result = this.value*((Scalar) other).value;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double result = this.value/((Scalar) other).value;
            return new Scalar(result);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
