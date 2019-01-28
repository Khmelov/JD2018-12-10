package by.it.moroz.jd01_15;

/**
 * File for delete all commentaries
 * and JavaDoc
 */

import java.io.*;

public class TaskB {

    public static void main(String[] args) {
        /*some commentary
         */

        String path = getPath("TaskB.java");
        StringBuilder sb = new StringBuilder();

        /*another commentary
         */
        deleteAnyComment(path, sb);
        //and else
        printToTxt(sb);

        //and else
        System.out.println(sb);
    }

    private static void printToTxt(StringBuilder sb) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getPath("TaskB.txt")))) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteAnyComment(String path, StringBuilder sb) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int someChar;
            while ((someChar = br.read()) != -1) if ((char) someChar == '/') {
                someChar = br.read();
                if ((char) someChar == '/') {
                    while ((char) someChar != '\n') {
                        someChar = br.read();
                    }
                    sb.append((char) someChar);
                } else if ((char) someChar == '*') {
                    while ((char) someChar != '/') {
                        someChar = br.read();
                    }
                } else {
                    sb.append('/').append((char) someChar);
                }
            } else sb.append((char) someChar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(String filename) {
        String path = TaskB.class.getName();
        String simpleName = TaskB.class.getSimpleName();
        path = path.replace(simpleName, "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }

}
