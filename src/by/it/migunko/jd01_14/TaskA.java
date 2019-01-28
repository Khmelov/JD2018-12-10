package by.it.migunko.jd01_14;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
        String path = getPath(TaskA.class, "dataTaskA.bin");
        System.out.println(path);

        writeBinaryFileWithInt(path);
        List<Integer> list = new ArrayList<>();
        double sum = 0;
        sum = readBinaryFileWithInt(path, list, sum);
        printToConsole(list, sum);
        printToFile(list, sum);
    }

    private static void printToFile(List<Integer> list, double sum) {
        String txtOut = getPath(TaskA.class, "resultTaskA.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(txtOut))) {
            //print to console
            for (Integer integer : list) {
                out.print(integer + " ");
            }
            out.println("\navg=" + sum / list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToConsole(List<Integer> list, double sum) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println("\navg=" + sum / list.size());
    }

    private static double readBinaryFileWithInt(String path, List<Integer> list, double sum) {
        //read
        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            while (dis.available() > 0) {
                int i = dis.readInt();
                sum += i;
                list.add(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }

    private static void writeBinaryFileWithInt(String path) {
        //write
        try (
                FileOutputStream fos = new FileOutputStream(path);
                DataOutputStream dos = new DataOutputStream(fos)
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 51));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
