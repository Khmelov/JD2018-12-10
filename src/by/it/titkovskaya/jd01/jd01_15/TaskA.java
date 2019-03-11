package by.it.titkovskaya.jd01.jd01_15;

import java.io.*;

/*
TaskA
 Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
 Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15. При выводе для
каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
 Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.
 */
public class TaskA {

    static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }

    public static void main(String[] args) {
        String fileName = getPath(TaskA.class, "matrix.txt");
        int[][] arr = new int[6][4];
        generate(arr);
        printTxt(arr, fileName);
        readTxt(arr, fileName);
        showArray(arr);
    }

    private static void generate(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 31) - 15;
            }
        }
    }

    private static void printTxt(int[][] arr, String fileName) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
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

    private static void readTxt(int[][] arr, String fileName) {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
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

    private static void showArray(int[][] arr) {
        for (int[] row : arr) {
            for (int element : row) {
                System.out.printf("%3d ", element);
            }
            System.out.println();
        }
    }
}
