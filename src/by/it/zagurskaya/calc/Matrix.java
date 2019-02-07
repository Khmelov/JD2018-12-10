package by.it.zagurskaya.calc;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;// поле объекта класса Matrix

    public Matrix(double[][] value /* локальная переменная конструктора (метода) */) {
        this.value = makeMatrixCopy(value);
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    private double[][] makeMatrixCopy(double[][] inputMatrix) {
        double[][] resultMatrix = new double[inputMatrix.length][];
        for (int i = 0; i < inputMatrix.length; i++) {
            resultMatrix[i] = Arrays.copyOf(inputMatrix[i], inputMatrix[i].length);
        }
        return resultMatrix;
    }

    public double[][] getValue() {
        return makeMatrixCopy(value);
    }

    public Matrix(String strMatrix) {
        int k = 0;
        String[] strings /* локальная переменная */ = strMatrix.replace(" ", "")
                .replace("{{", "")
                .replace("}}", "")
                .split("},\\{");

        value = new double[strings.length][];

        for (int i = 0; i < strings.length; i++) {
            String secondLevel = strings[i];
            String[] valueStringArray = secondLevel.split(",");
            double[] doubles = new double[valueStringArray.length];
            for (int j = 0; j < valueStringArray.length; j++) {
                double v = Double.parseDouble(valueStringArray[j]);
                doubles[j] = v;
            }
            value[i] = doubles;
        }
    }

    @Override
    public Var add(Var other)throws CalcException {
        if (other instanceof Scalar) {
            double[][] resSkal = makeMatrixCopy(value);
            for (int i = 0; i < resSkal.length; i++) {
                for (int j = 0; j < resSkal[i].length; j++) {
                    resSkal[i][j] = ((Scalar) other).getValue() + resSkal[i][j];
                }
            }
            return new Matrix(resSkal);
        } else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length) {

                double[][] resMatr = makeMatrixCopy(value);
                for (int i = 0; i < resMatr.length; i++) {
                    if (this.value.length == resMatr[i].length) {
                        for (int j = 0; j < resMatr[i].length; j++) {
                            resMatr[i][j] = ((Matrix) other).value[i][j] + resMatr[i][j];
                        }
                    }
                }
                return new Matrix(resMatr);
            }
        } else if ((other instanceof Vector)) {
            throw new CalcException(LocalMessages.ADDITION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get()); //addition impossible

        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = makeMatrixCopy(value);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            if ((this.value.length == ((Matrix) other).value.length)&(this.value[0].length == ((Matrix) other).value[0].length)) {
                double[][] res = makeMatrixCopy(value);
                for (int i = 0; i < res.length; i++) {
                    if (this.value.length == res[i].length) {
                        for (int j = 0; j < res[i].length; j++) {
                            res[i][j] = res[i][j] - ((Matrix) other).value[i][j];
                        }
                    } else {
                        throw new CalcException(LocalMessages.SUBTRACTION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get()); //subtraction impossible

                    }
                }
                return new Matrix(res);
            }
        } else if ((other instanceof Vector)) {
            throw new CalcException(LocalMessages.SUBTRACTION_SUPPLIER.get() + LocalMessages.IMPOSSIBLE_SUPPLIER.get()); //subtraction impossible

        }
        return super.sub(other);
    }


    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            if (this.value[0].length == ((Vector) other).getValue().length) {
                double[] rezMultMatrixVector = new double[this.value.length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        rezMultMatrixVector[i] = rezMultMatrixVector[i] + this.value[i][j] * ((Vector) other).getValue()[j];
                    }
                }
                return new Vector(rezMultMatrixVector);
            }
        } else if (other instanceof Matrix) {
            if (this.value[0].length == ((Matrix) other).value.length) {
                double[][] rezMultMatrixMatrix = new double[this.value.length][((Matrix) other).value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                        for (int k = 0; k < ((Matrix) other).value.length; k++) {
                            rezMultMatrixMatrix[i][j] = rezMultMatrixMatrix[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                        }
                    }
                }
                return new Matrix(rezMultMatrixMatrix);
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
        StringBuilder out = new StringBuilder("{");
        String delimiteri = "";
        String delimiterj = "";
        for (int i = 0; i < value.length; i++) {
            out.append(delimiteri).append('{');
            delimiterj = "";
            for (int j = 0; j < value[i].length; j++) {
                out.append(delimiterj).append(value[i][j]);
                delimiterj = ", ";
            }
            out.append('}');
            delimiteri = ", ";
        }
        out.append('}');

        return out.toString();
    }
}
