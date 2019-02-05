package by.it.yarmolenka.jd02_05.MathCalc.Variables;

public class Scalar extends Var {

    public double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String s) {
        this.value = Double.parseDouble(s);
    }

    @Override
    public String toString(){
        return Double.toString(this.value);
    }
}
