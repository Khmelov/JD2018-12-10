package by.it.titkovskaya.jd01.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "A", 3);

        double minimum = Helper.findMin(array);
        System.out.println(minimum);

        double maximum = Helper.findMax(array);
        System.out.println(maximum);

        Helper.sort(array);
        InOut.printArray(array);

        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        boolean upDirection = true;
        Helper.sort(arr, !upDirection);
        InOut.printArray(arr);

        double[][] matrix = new double[3][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.random() * 10 + 1;
            }
        }
        double[] vector = {2, 3, 4, 5};
        double[] newVector = Helper.mul(matrix, vector);
        InOut.printArray(newVector);

        double[][] secMatrix = new double[4][5];
        for (int i = 0; i < secMatrix.length; i++) {
            for (int j = 0; j < secMatrix[i].length; j++) {
                secMatrix[i][j]=Math.random()*10+1;
            }
        }
        double[][] newMatrix = Helper.mul(matrix,secMatrix);
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.printf("% -8.1f", newMatrix[i][j]);
            }
            System.out.println();
        }
    }
}

/*

        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        Arrays.sort(arr);
        InOut.printArray(arr);

        double[][] secMatrix = {
                {2.0,3,4,5},
                {5,6,7,8},
                {9,0,1.1,2},
                {3,4,5,6}
        };

 */