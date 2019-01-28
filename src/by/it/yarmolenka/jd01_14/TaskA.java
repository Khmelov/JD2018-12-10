package by.it.yarmolenka.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class TaskA {

    public static void main(String[] args) {
        String path = getPath(TaskA.class, "dataTaskA.bin");
        writeIntsToBinFile(path);
        double sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        sum = readBinaryFileCountSum(path, list, sum);
        writeToConsole(list, sum);
        writeToFile(list, sum);
    }

    private static void writeToFile(ArrayList<Integer> list, double sum) {
        String path2 = getPath(TaskA.class, "resultTaskA.txt");
        try (
                PrintWriter pw = new PrintWriter(
                        new FileWriter(
                                new File(path2)
                        )
                )
        ) {
            for (Integer integer : list) {
                pw.print(integer + " ");
            }
            pw.println("\navg=" + sum / list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToConsole(ArrayList<Integer> list, double sum) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println("\navg=" + sum / list.size());
    }

    private static double readBinaryFileCountSum(String path, ArrayList<Integer> list, double sum) {
        try (
                DataInputStream dis = new DataInputStream(
                        new FileInputStream(
                                new File(path)
                        )
                )
        ) {
            while (dis.available() > 0) {
                int i = dis.readInt();
                list.add(i);
                sum += i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }

    private static void writeIntsToBinFile(String path) {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new FileOutputStream(path)
                )
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 51));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(".", File.separator);
        path = path.replace(clazz.getSimpleName(), "");
        path = System.getProperty("user.dir") + File.separator
                + "src" + File.separator + path;
        return path + filename;
    }
}
