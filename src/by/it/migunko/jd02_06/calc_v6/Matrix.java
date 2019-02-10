package by.it.migunko.jd02_06.calc_v6;

public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }
    public Matrix(String strMatrix){
        String[] strValues = strMatrix
                .replaceAll("\\{\\{|\\}\\}", "")
                .trim()
                .split("\\},\\s?\\{");//?
        String[] strValues1 = strValues[0]
                .trim()
                .split(",\\s?");
        value = new double[strValues.length][strValues.length];
        for (int i = 0; i < strValues.length; i++) {
            String[] matrix = strValues[i]
                    .trim()
                    .split(",\\s?");
            for (int j = 0; j < strValues.length; j++) {
                value[i][j] = Double.parseDouble(matrix[j]);
            }
        }
    }

}

