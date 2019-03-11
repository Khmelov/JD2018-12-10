package by.it.titkovskaya.jd01.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    public Matrix(String strMatrix) {
        Pattern pattern = Pattern.compile("[{][0-9., ]+[}]");
        StringBuilder sb = new StringBuilder(strMatrix);
        Matcher matcher = pattern.matcher(sb);
        int rowsQuantity = 0;
        while (matcher.find()) {
            rowsQuantity++;
        }
        String[] newMatrix = strMatrix.replaceAll("[^.,0-9]", "").split(",");
        int columnsQuantity = newMatrix.length / rowsQuantity;
        this.value = new double[rowsQuantity][columnsQuantity];
        for (int k = 0; k < newMatrix.length; k++) {
            for (int i = 0; i < rowsQuantity; i++) {
                for (int j = 0; j < columnsQuantity; j++) {
                    value[i][j] = Double.parseDouble(newMatrix[k]);
                    k++;
                }
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j]=this.value[i][j]+((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix){
            if (this.value.length==((Matrix) other).value.length && this.value[0].length==((Matrix) other).value[0].length){
                double[][] res = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j]=this.value[i][j]+((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j]=this.value[i][j]-((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix){
            if (this.value.length==((Matrix) other).value.length && this.value[0].length==((Matrix) other).value[0].length){
                double[][] res = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j]=this.value[i][j]-((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j]=this.value[i][j]*((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Vector){
            if (this.value[0].length==((Vector) other).getValue().length){
                double[] res = new double[((Vector) other).getValue().length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                        res[i]=res[i]+this.value[i][j]*((Vector) other).getValue()[j];
                    }
                }
                return new Vector(res);
            }
        }
        else if (other instanceof Matrix){
            if (this.value.length==((Matrix) other).value.length && this.value[0].length==((Matrix) other).value[0].length){
               double[][] res = new double[value.length][((Matrix) other).value[0].length];
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                        for (int k = 0; k < ((Matrix) other).value.length; k++) {
                            res[i][j] = res[i][j]+this.value[i][k]*((Matrix) other).value[k][j];
                        }
                    }
                }
                return new Matrix(res);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
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
