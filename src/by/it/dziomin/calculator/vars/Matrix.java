package by.it.dziomin.calculator.vars;

import by.it.dziomin.calculator.CalcException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];

        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    public Matrix(Matrix matrix) {
        this.value = new double[matrix.getValue().length][matrix.getValue()[0].length];
        for (int i = 0; i < matrix.getValue().length; i++) {
            System.arraycopy(matrix.getValue()[i], 0, this.value[i], 0, value[i].length);
        }
    }

    public Matrix(String strMatrix) {
        Pattern patternRows = Pattern.compile("\\{(.*?)}");
        Pattern patternColumns = Pattern.compile("[0-9.]{1,}");
        Matcher matcherRows = patternRows.matcher(strMatrix);

        // считаем количество строк в матрице и заполняем массив строк
        int countRows = 0;
        while (matcherRows.find()) {
            countRows++;
        }
        String[] rows = new String[countRows];
        countRows = 0;
        matcherRows = patternRows.matcher(strMatrix);
        while (matcherRows.find()) {
            rows[countRows] = matcherRows.group();
            countRows++;
        }

        // считаем количество столбцов в матрице
        int countColumns = 0;
        Matcher matcherColumns = patternColumns.matcher(rows[0]);
        while (matcherColumns.find()) {
            countColumns++;
        }

        // инициализируем матрицу и заполняем все ячейки матрицы
        double[][] matrix = new double[countRows][countColumns];

        for (int i = 0; i < countRows; i++) {

            int j = 0;
            matcherColumns = patternColumns.matcher(rows[i]);
            while (matcherColumns.find()) {
                matrix[i][j] = Double.parseDouble(matcherColumns.group());
                j++;
            }
        }

        this.value = new double[countRows][countColumns];

        for (int i = 0; i < countRows; i++) {
            for (int j = 0; j < countColumns; j++) {
                System.arraycopy(matrix[i], 0, this.value[i], 0, countColumns);
            }
        }
    }

    @Override
    public boolean isMatrix() {
        return true;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";

        for (int i = 0; i < value.length; i++) {
            out.append('{');
            for (int j = 0; j < value[i].length; j++) {
                out.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            out.append("}");
            if (i != value.length - 1) {
                out.append(", ");
            }

            delimiter = "";
        }
        out.append('}');
        return out.toString();
    }

    public double[][] getValue() {
        return value;
    }

    public void setValue(double[][] value) {
        this.value = value;
    }



    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] result = new double[this.getValue().length][this.getValue()[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.getValue()[i][j] + ((Scalar) other).getValue();
                }

            }
            return new Matrix(result);
        }

        if (other instanceof Matrix && this.getValue().length == ((Matrix) other).getValue().length && ((Matrix) other).getValue()[0].length == this.getValue()[0].length) {
            double[][] result = new double[this.getValue().length][this.getValue()[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.getValue()[i][j] + ((Matrix) other).getValue()[i][j];
                }

            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other.isScalar()) {
            double[][] result = new double[this.getValue().length][this.getValue()[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.getValue()[i][j] - ((Scalar) other).getValue();
                }

            }
            return new Matrix(result);
        }

        if (other.isMatrix() && this.getValue().length == ((Matrix) other).getValue().length && ((Matrix) other).getValue()[0].length == this.getValue()[0].length) {
            double[][] result = new double[this.getValue().length][this.getValue()[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.getValue()[i][j] - ((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other.isScalar()) {
            double[][] result = new double[this.getValue().length][this.getValue()[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.getValue()[i][j] * ((Scalar) other).getValue();
                }

            }
            return new Matrix(result);
        }

        if (other.isVector() && this.getValue()[0].length == ((Vector) other).getValue().length) {
            double[] result = new double[this.getValue().length];
            for (int i = 0; i < this.getValue().length; i++) {
                for (int j = 0; j < this.getValue()[0].length; j++) {
                    result[i] = this.getValue()[i][j] * ((Vector) other).getValue()[j] + result[i];
                }
            }
            return new Vector(result);
        }

        if (other.isMatrix() && this.getValue()[0].length == ((Matrix) other).getValue().length) {
            double[][] result = new double[this.getValue().length][((Matrix) other).getValue()[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).getValue().length; k++) {
                        result[i][j] = this.getValue()[i][k] * ((Matrix) other).getValue()[k][j] + result[i][j];
                    }
                }
            }
            return new Matrix(result);
        }

        return super.mul(other);
    }

    @Override
    public Var div(Var other)throws CalcException {
        if (other.isScalar()) {
            double[][] result = new double[this.getValue().length][this.getValue()[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.getValue()[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        return super.div(other);
    }
}
