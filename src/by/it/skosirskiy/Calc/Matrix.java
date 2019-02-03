package by.it.skosirskiy.Calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    private Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix1) {

        this.value = matrix1.value;
    }

    Matrix(String str) {
        Pattern pattern = Pattern.compile("[{][0-9 ,.]*[}]");
        StringBuilder sb = new StringBuilder(str);
        Matcher matcher = pattern.matcher(sb);


        int kolrows = 0; //kolich simvolov
        while (matcher.find()) {
            kolrows++;
        }

        String[] strMatrix = str.replaceAll("[^,.0-9]", "").split(",");

        int columns = strMatrix.length / kolrows; // shctchik elment v matrice
        this.value = new double[kolrows][columns];
        for (int k = 0; k < strMatrix.length; k++) {
            for (int i = 0; i < kolrows; i++) {
                for (int j = 0; j < columns; j++) {
                    value[i][j] = Double.parseDouble(strMatrix[k]);
                    k++;
                }
            }
        }

    }

    @Override
    public Var add(Var other)  throws CalcException{
        if (other instanceof Scalar) {
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] res = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
        }

        return super.add(other);
    }

    @Override
    public Var sub(Var other)  throws CalcException{
        if (other instanceof Scalar) {
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] res = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
        }


        return super.sub(other);
    }

    @Override
    public Var mul(Var other)  throws CalcException{
        if (other instanceof Scalar) {
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        if (other instanceof Vector) {
            if (this.value[0].length == ((Vector) other).getValue().length) {
                double[] res = new double[((Vector) other).getValue().length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                        res[i] = res[i] + this.value[i][j] * ((Vector) other).getValue()[j];
                    }
                }
                return new Vector(res);
            }
        }
        if (other instanceof Matrix)  {
            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] res = new double[value.length][((Matrix) other).getValue().length];
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value.length; j++) {
                        for (int k = 0; k < ((Matrix) other).value.length; k++) {
                            res[i][j] = res[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                        }
                    }

                }
                return new Matrix(res);

            }
        }

        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{{");
        String delimiter = "";
        for (double[] doubles : value) {
            for (double v : doubles) {
                out.append(delimiter).append(v);
                delimiter = ", ";
            }
            delimiter = "}, {";
        }
        out.append("}}");
        return out.toString();
    }
}
