package by.it.titkovskaya.jd01.jd01_04;

public class Helper {
    static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    static void sort(double[] arr) {
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
    }

    static void sort(double[] arr, boolean upDirection) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((upDirection && arr[i] > arr[j]) || (!upDirection && arr[i] < arr[j])) {
                    double buffer = arr[i];
                    arr[i] = arr[j];
                    arr[j] = buffer;
                }
            }
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] newVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                newVector[i] = newVector[i] + matrix[i][j] * vector[j];
            }
        }
        return newVector;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] newMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    newMatrix[i][j]=newMatrix[i][j]+ matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return newMatrix;
    }
}

/*


        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]) {
                    double buffer = arr[i];
                    arr[i]=arr[j];
                    arr[j]=buffer;
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[j - 1] > arr[j]) {
                    double buffer = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = buffer;
                }
            }
        }


 */