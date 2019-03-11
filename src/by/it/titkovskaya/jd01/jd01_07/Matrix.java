package by.it.titkovskaya.jd01.jd01_07;

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
        Pattern pattern = Pattern.compile("[{][0-9, ]+[}]");
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
