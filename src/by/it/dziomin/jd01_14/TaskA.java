package by.it.dziomin.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    public static void main(String[] args) {
        String path = getPass(TaskA.class, "dataTaskA.bin");

        fileBinaryWriter(path);
        List<Integer> list = fileBinaryReader(path);
        double avg = calculateAvg(list);

        path = getPass(TaskA.class, "resultTaskA.txt");

        StringBuilder sb = new StringBuilder();
        list.forEach(e -> sb.append(e).append(" "));
        String text = sb.toString();

        printToConsole(text, avg);

        printToFile(text, path, false);
        printToFile(avg, path);
    }


    static String getPass(Class<?> clas, String fileName) {

        String path = System.getProperty("user.dir") + "\\src\\" + clas.getName();
        path = path.replace("TaskA", "");
        path = path.replace("TaskB", "");
        path = path.replace("TaskC", "");
        path = path.replace(".", "\\");
        path = path + fileName;

        return path;
    }

    private static void fileBinaryWriter(String path) {
        try (FileOutputStream fos = new FileOutputStream(path);
             DataOutputStream dos = new DataOutputStream(fos)) {
            for (int i = 0; i < 20; i++) {
                int rand = (int) (Math.random() * 100) - 50;
                dos.writeInt(rand);
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи бинарного файла: " + e.getMessage());
        }
    }

    private static List<Integer> fileBinaryReader(String path) {
        List<Integer> arrayList = new ArrayList<>(20);

        try (FileInputStream fis = new FileInputStream(path);
             DataInputStream dis = new DataInputStream(fis)) {
            for (int i = 0; i < 20; i++) {
                int readIntFromFile = dis.readInt();

                arrayList.add(readIntFromFile);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения бинарного файла: " + e.getMessage());
        }
        return arrayList;
    }

    private static double calculateAvg(List<Integer> arrayList) {
        double sum = 0;
        for (Integer num : arrayList) {
            sum += num;
        }
        return sum / arrayList.size();
    }

    private static void printToConsole(String text, double avg) {
        System.out.println(text);
        System.out.println("avg=" + avg);
    }

    static void printToFile(String text, String path, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, append))) {
            writer.write(text);
        } catch (IOException e) {
            System.err.println("Ошибка печати текста в файл: " + e.getMessage());
        }
    }

    private static void printToFile(double avg, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write("\navg=" + avg);
        } catch (IOException e) {
            System.err.println("Ошибка печати результата в файл: " + e.getMessage());
        }
    }

}
