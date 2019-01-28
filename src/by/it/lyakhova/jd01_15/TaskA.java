package by.it.lyakhova.jd01_15;

import java.io.*;

public class TaskA {


    private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + path;
        return path + filename;
    }

    public static void main(String[] args) {
        String filename = getPath(TaskA.class, "matrix.txt");
        int[][] arr = new int[6][4];
        generate(arr);
        printTxt(arr, filename);
        readTxt(arr, filename);
        showArray(arr);
    }

    private static void showArray(int[][] arr) {
        for (int[] row : arr) {
            for (int element : row) {
                System.out.printf("%3d ", element);
            }
            System.out.println();
        }
    }

    private static void readTxt(int[][] arr, String filename) {
        try (BufferedReader in =
                     new BufferedReader(
                             new FileReader(filename)
                     )
        ) {
            int i = 0;
            for (; ; ) {
                String line = in.readLine();
                if (line == null) break;
                String[] sRow = line.trim().split("\\s+");
                for (int j = 0; j < sRow.length; j++) {
                    arr[i][j] = Integer.parseInt(sRow[j]);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printTxt(int[][] arr, String filename) {
        try (PrintWriter out =
                     new PrintWriter(
                             new FileWriter(filename)
                     )
        ) {
            for (int[] row : arr) {
                for (int element : row) {
                    out.printf("%3d ", element);
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generate(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = -15 + (int) (31 * Math.random());
            }
        }
    }
}
