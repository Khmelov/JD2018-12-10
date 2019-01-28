package by.it.kushnerov.jd01_15;

import by.it.zagurskaya.jd01_11.Task;

import java.io.*;
import java.nio.Buffer;

public class TaskA {
    public static void main(String[] args) {
        int[][] array = new int[6][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] =-15+(int)(31*Math.random());
            }
        }
        String filename = getPath(TaskA.class,"matrix.txt");
        try (PrintWriter out =new PrintWriter(new FileWriter(filename))){
            for (int[] row : array){
                for (int element : row){
                    out.printf("%3d ",element);
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try (BufferedReader in = new BufferedReader(new FileReader(filename))
//        {
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + path;
        System.out.println(path);
        return path+filename;
    }
}
