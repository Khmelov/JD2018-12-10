package by.it.subach.jd01_15;

import java.io.*;

public class TaskA {

    static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        String simpleName = clazz.getSimpleName();
        path = path.replace(simpleName, "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }


    public static void main(String[] args) {
        int [][] arr = new int[6][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                arr[i][j] = -15 + (int)(31 * Math.random());
            }
        }
        String fileName = getPath(TaskA.class, "matrix.txt");

        try(PrintWriter out = new PrintWriter(new FileWriter(fileName))){
            for (int[] row : arr) {
                for (int element : row) {
                    out.printf("%3d ", element);
                }
                out.println();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        try(BufferedReader in = new BufferedReader(new FileReader(fileName))){
            int i = 0;
            for(;;){
                String line = in.readLine();
                if(line == null)        break;
                String [] sRow = line.trim().split("\\s+");

                for (int j = 0; j < sRow.length; j++) {
                    arr[i][j] = Integer.parseInt(sRow[j]);
                }
                i++;
            }


        }catch (IOException e){
            e.printStackTrace();
        }

        for (int[] row : arr) {
            for (int element : row) {
                System.out.printf("%3d ", element);
            }
            System.out.println();
        }

    }

}
