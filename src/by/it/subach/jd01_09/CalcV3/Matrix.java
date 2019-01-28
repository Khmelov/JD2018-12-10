package by.it.subach.jd01_09.CalcV3;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    public double[][] getValue() {
        return value;
    }
    Scalar minus = new Scalar(-1);

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    Matrix(Matrix matrix) {
//        value = Arrays.copyOf(matrix.value, matrix.value.length);
//        this.value = new double[matrix.value.length][];
//        System.arraycopy(matrix.value, 0, this.value, 0, this.value.length);
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String[] lines = strMatrix.split("},");
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replace('}', ' ').replace('{', ' ').trim();
        }
        this.value = new double[lines.length][];
        for (int i = 0; i < value.length; i++) {
            String[] col = lines[i].split(",");
            this.value[i] = new double[col.length];
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(col[j]);
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

    //    Matrix + Matrix
    @Override
    public Var add2(Matrix other) throws CalcException {
        if (this.value.length == other.value.length &&
                this.value[0].length == other.value[0].length) {
            double[][] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] += other.value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.add(other);
    }


    //    Matrix - Matrix
    @Override
    public Var sub2(Matrix other) throws CalcException {
        return other.add(this.mul(minus));
    }

    //    Matrix * Matrix
    @Override
    public Var mul2(Matrix other) throws CalcException {
        if (other.value[0].length == (this.getValue().length)) {
            double[][] res = new double[other.value.length][this.value[0].length];
            for (int i = 0; i < other.value.length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    double sum = 0;
                    for (int k = 0; k < other.value[j].length; k++) {
                        sum += other.value[i][k] * this.value[k][j];
                    }
                    res[i][j] = sum;
                }
            }
            return new Matrix(res);
        }
        return super.mul(this);
    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            out.append("{");
            for (int j = 0; j < value[i].length; j++) {
                out.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if (i == value.length - 1) {
                out.append("}");
            } else {
                out.append("}, ");
                delimiter = "";
            }
        }
        out.append("}");
        return out.toString();
    }
}
