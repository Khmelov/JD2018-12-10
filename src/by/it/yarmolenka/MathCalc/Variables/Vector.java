package by.it.yarmolenka.MathCalc.Variables;

import by.it.yarmolenka.MathCalc.CalcException;
import by.it.yarmolenka.MathCalc.Strings.MathError;
import by.it.yarmolenka.MathCalc.Translator;

import java.util.Arrays;

public class Vector extends Var {
    private static Translator translator = Translator.INSTANCE;
    public double[] value;

    public Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    public Vector(Vector vec) {
        this.value = new double[vec.value.length];
        System.arraycopy(vec.value, 0, this.value, 0, vec.value.length);
    }

    public Vector(String s) {
        s = s.replace(".0", "");
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] split = s.split(",");
        this.value = new double[split.length];
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
            this.value[i] = Double.parseDouble(split[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        return other.add2(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return other.sub2(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return other.mul2(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return other.div2(this);
    }

    public Var add2(Scalar scalar) {
        return scalar.add2(this);
    }

    public Var add2(Vector vector) throws CalcException {
        if (vector.value.length != this.value.length)
            throw new CalcException(translator.get(MathError.ADD), translator);
        double[] res = Arrays.copyOf(vector.value, vector.value.length);
        for (int i = 0; i < res.length; i++)
            res[i] += this.value[i];
        return new Vector(res);
    }

    public Var sub2(Scalar scalar) throws CalcException {
        return scalar.sub2(this).mul(Scalar.MINUS);
    }

    public Var sub2(Vector vector) throws CalcException {
        if (vector.value.length != this.value.length)
            throw new CalcException(translator.get(MathError.SUB), translator);
        double[] res = Arrays.copyOf(vector.value, vector.value.length);
        for (int i = 0; i < res.length; i++)
            res[i] -= this.value[i];
        return new Vector(res);
    }

    public Var mul2(Scalar scalar) {
        return scalar.mul2(this);
    }

    public Var mul2(Vector vector) throws CalcException {
        if (vector.value.length != this.value.length)
            throw new CalcException(translator.get(MathError.MUL), translator);
        double res = 0;
        for (int i = 0; i < this.value.length; i++)
            res += this.value[i] * vector.value[i];
        return new Scalar(res);
    }

    public Var mul2(Matrix matrix) throws CalcException {
        if (matrix.value[0].length != this.value.length)
            throw new CalcException(translator.get(MathError.MUL), translator);
        double[] res = new double[matrix.value.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < matrix.value[0].length; j++) {
                res[i] += matrix.value[i][j] * this.value[j];
            }
        }
        return new Vector(res);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder del = new StringBuilder(", ");
        sb.append(this.value[0]);
        for (int i = 1; i < this.value.length; i++) {
            sb.append(del).append(this.value[i]);
        }
        sb.append("}");
        return sb.toString();
    }
}
