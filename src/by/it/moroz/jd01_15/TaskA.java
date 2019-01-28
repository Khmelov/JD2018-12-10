package by.it.moroz.jd01_15;

import java.io.*;

public class TaskA {

    public static void main(String[] args) {
        int [][] numbers = new int[6][4];
        generateMatrix(numbers);
        String fileName = System.getProperty("user.dir")+"/src/by/it/moroz/jd01_15/matrix.txt";
        printToFile(numbers, fileName);
        readFile(numbers, fileName);
        showArray(numbers);
    }

    private static void showArray(int[][] numbers) {
        for (int[] row : numbers) {
            for (int i : row) {
                System.out.printf("%3d ", i);
            }
            System.out.println();
        }
    }

    private static void readFile(int[][] numbers, String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            int i=0;
            for (;;) {
                String line = reader.readLine();
                if (line == null) break;
                String[] row = line.trim().split("\\s+");
                for (int j = 0; j < row.length; j++) {
                    numbers[i][j] = Integer.parseInt(row[j]);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToFile(int[][] numbers, String fileName) {
        try(PrintWriter out = new PrintWriter(
                new FileWriter(fileName))){

            for (int[] row : numbers) {
                for (int i : row) {
                    out.printf("%3d ", i);
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateMatrix(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                numbers[i][j]= (int) (Math.random()*31-15);
            }
        }
    }
}
