package by.it.moroz.calc;


public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
                System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("\\{", "");
        strMatrix = strMatrix.substring(0, strMatrix.length() - 2);
        String[] row = strMatrix.split("},");
        for (int i = 0; i < row.length; i++) {
            row[i] = row[i].trim();
        }
        this.value = new double[row.length][];
        for (int i = 0; i < row.length; i++) {
            String[] single_int = row[i].split(",");
            this.value[i]= new double[single_int.length];
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(single_int[j]);
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length || this.value[0].length == ((Matrix) other).value[0].length) {
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
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar minus = new Scalar(-1);
            return this.add(other.mul(minus));
        } else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length
                    && this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] res = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res.length; j++) {
                        res[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).getValue().length) {
                double[] res = new double[this.value.length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                        res[i]+=this.value[i][j]*((Vector) other).getValue()[j];
                    }
                }
                return new Vector(res);
            }
        } else if(other instanceof Matrix){
            if(this.value.length == ((Matrix) other).value.length
                    || this.value[0].length == ((Matrix) other).value[0].length){
                double[][]res = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                        for (int k = 0; k < ((Matrix) other).value.length; k++) {
                            res[i][j]+=this.value[i][k]*((Matrix) other).value[k][j];
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
        if (other instanceof Scalar) {
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{{");
        String delimiter = "";
        for (double[] doubles : value) {
            for (int j = 0; j < value[0].length; j++) {
                out.append(delimiter).append(doubles[j]);
                delimiter = ", ";
            }
            delimiter = "}, {";
        }
        out.append("}}");
        return out.toString();
    }
}
