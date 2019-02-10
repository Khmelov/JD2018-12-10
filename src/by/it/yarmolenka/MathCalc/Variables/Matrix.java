package by.it.yarmolenka.MathCalc.Variables;

import by.it.yarmolenka.MathCalc.CalcException;
import by.it.yarmolenka.MathCalc.Strings.MathError;
import by.it.yarmolenka.MathCalc.Translator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private static Translator translator = Translator.INSTANCE;

    public double[][] value;

    public Matrix(double[][] array) {
        this.value = new double[array.length][array[0].length];
        for (int i = 0; i < array.length; i++)
            System.arraycopy(array[i], 0, this.value[i], 0, array[i].length);
    }

    public Matrix(Matrix mat) {
        this.value = new double[mat.value.length][mat.value[0].length];
        for (int i = 0; i < mat.value.length; i++)
            System.arraycopy(mat.value[i], 0, this.value[i], 0, mat.value[i].length);
    }

    public Matrix(String s) {

        //Убираем .0 и разделяем строку на одномерные массивы
        s = s.replace(".0", "");
        Pattern pt = Pattern.compile("[{][0-9., -]+[}]");
        Matcher m1 = pt.matcher(s);
        ArrayList<String> list = new ArrayList<>();
        while (m1.find()) list.add(m1.group());

        //выясняем количество членов в одномерных массивах и задаём размеры матрице this
        String[] buf = list.get(0).split(",");
        this.value = new double[list.size()][buf.length];

        //убираем лишние символы из одномерных массивов и переносим данные в матрицу this
        for (int i = 0; i < list.size(); i++) {
            String buff = list.get(i).replace("{", "");
            buff = buff.replace("}", "");
            String[] str = buff.split(",");
            for (int j = 0; j < str.length; j++) {
                this.value[i][j] = Double.parseDouble(str[j]);
            }
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

    public Var add2(Scalar scalar) throws CalcException {
        return scalar.add2(this);
    }

    public Var add2(Matrix matrix) throws CalcException {
        if (this.value.length != matrix.value.length ||
                this.value[0].length != matrix.value[0].length)
            throw new CalcException(translator.get(MathError.ADD), translator);
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++)
                res[i][j] = this.value[i][j] + matrix.value[i][j];
        }
        return new Matrix(res);
    }

    public Var sub2(Scalar scalar) throws CalcException {
        return scalar.add2(this).mul(Scalar.MINUS);
    }

    public Var sub2(Matrix matrix) throws CalcException {
        if (this.value.length != matrix.value.length ||
                this.value[0].length != matrix.value[0].length)
            throw new CalcException(translator.get(MathError.ADD), translator);
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++)
                res[i][j] = matrix.value[i][j] - this.value[i][j];
        }
        return new Matrix(res);
    }

    public Var mul2(Scalar scalar) {
        return scalar.mul2(this);
    }

    public Var mul2(Matrix matrix) throws CalcException {
        if (matrix.value[0].length != this.value.length)
            throw new CalcException(translator.get(MathError.MUL), translator);
        double[][] res = new double[matrix.value.length][this.value[0].length];
        for (int i = 0; i < res.length; i++)
            for (int j = 0; j < res[i].length; j++)
                for (int k = 0; k < matrix.value[0].length; k++)
                    res[i][j] += matrix.value[i][k] * this.value[k][j];
        return new Matrix(res);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder del = new StringBuilder(", ");
        for (int i = 0; i < this.value.length; i++) {
            sb.append("{").append(this.value[i][0]);
            for (int j = 1; j < this.value[i].length; j++)
                sb.append(del).append(this.value[i][j]);
            sb.append("}");
            if (i < this.value.length - 1) sb.append(del);
        }
        sb.append("}");
        return sb.toString();
    }
}
