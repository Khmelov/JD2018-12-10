package by.it.yarmolenka.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        String path = getPath(TaskA.class) + "matrix.txt";
        matrixToFile(matrix, path);
        fileToConsole(path);
    }

    private static void fileToConsole(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String s;
            while (!((s = br.readLine()) == null)){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void matrixToFile(int[][] matrix, String path) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            for (int[] row : matrix) {
                for (int e : row) {
                    writer.printf("%3d ", e);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][] createMatrix() {
        int[][] mat = new int[6][4];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = (int) (Math.random()*31)-15;
            }
        }
        return mat;
    }

    static String getPath(Class<?> clazz) {
        String path = clazz.getName().replace(".", File.separator)
                .replace(clazz.getSimpleName(), "");
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
    }
}
