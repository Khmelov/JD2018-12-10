package by.it.dziomin.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {

        int rowsCount = 6;
        int columnsCount = 4;

        String fileName = System.getProperty("user.dir") + "\\src\\by\\it\\dziomin\\jd01_15\\matrix.txt";
        String[] rows = new String[rowsCount];
        printToFile(fileName, generateMatrix(rowsCount, columnsCount), rows);
        int[][] arr = readFromFileToArray(fileName, rowsCount, columnsCount);
        printToConsole(arr);

    }

    private static int[][] generateMatrix(int a, int b) {
        int[][] arr = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = (int) (31 * Math.random()) - 15;
            }
        }
        return arr;
    }

    private static void printToFile(String fileName, int[][] arr, String[] array) {


        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < arr.length; i++) {
                array[i] = "";
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = (int) (31 * Math.random()) - 15;
                    writer.printf("%3d ", arr[i][j]);
                    array[i] = array[i] + " " + arr[i][j];
                }
                writer.println();
            }


        } catch (
                IOException e) {
            System.err.println("Ошибка печати текста в файл: " + e.getMessage());
        }
    }

    private static int[][] readFromFileToArray(String fileName, int a, int b) {
        int[][] arr = new int[a][b];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {


            String[] elements;
            int i = 0;
            for (; ; ) {
                String line = reader.readLine();
                if (line == null) break;
                elements = line.trim().split("\\s+");
                for (int j = 0; j < elements.length; j++) {
                    arr[i][j] = Integer.parseInt(elements[j]);
                }
                i++;
            }
        } catch (
                IOException e) {
            System.err.println("Ошибка печати текста в файл: " + e.getMessage());
        }
        return arr;
    }

    private static void printToConsole(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%3d ", ints[j]);
            }
            System.out.println();
        }
    }

}
