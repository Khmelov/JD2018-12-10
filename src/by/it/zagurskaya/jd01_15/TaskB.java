package by.it.zagurskaya.jd01_15;

import java.io.*;

public class TaskB {
    /**
     * sdasdfasdf
     * asdfasdfasd
     *
     * @param args
     */

    public static void main(String[] args) {
        String filePath = getPath(TaskBB.class, "TaskB.java");
        String filename = getPath(TaskBB.class, "TaskB.txt");
        StringBuilder textFromFile = new StringBuilder();
        textFromFile = readTextFile(filePath, textFromFile);
        textFromFile = deleteComentsFromText(textFromFile);
        printToFile(filename,textFromFile);

    }
    //sssssssssssssssss
    /*xzcvzxcvzxc
    zxcvzxcvzxcv
     */

    private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + path;
        return path + filename;
    }
    //sssssssssssssssss

    private static StringBuilder readTextFile(String path, StringBuilder textFromFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String value = br.readLine(); value != null; value = br.readLine()) {
                textFromFile.append(value).append('\n');
                int i = 0;
            }
          //  System.out.println("конец файла");
        } catch (IOException e) {
            System.err.println("что-то пошло не так, т.к. " + e.getMessage());
        }
        return textFromFile;
    }
    /*xzcvzxcvzxc
    zxcvzxcvzxcv
     */

    private static void printToFile(String path, StringBuilder results) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i <results.length() ; i++) {

                out.print(results.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*xzcvzxcvzxc
    zxcvzxcvzxcv
     */

    private static StringBuilder deleteComentsFromText(StringBuilder text) {
        char searchChar1 = '/';
        char searchChar2 = '*';
        char searchChar3 = '\n';
        int i = 0;
        while (i < text.length() - 2) {
            if ((text.charAt(i) == searchChar1) & (text.charAt(i + 1) == searchChar2)) {
                int firstCharIndex = i;
                int j = i + 2;
                while (text.charAt(j) != searchChar1) {
                    j++;
                }
                int lastCharIndex = j;
                text.delete(firstCharIndex, lastCharIndex+1);
                j=0;
            } else if ((text.charAt(i) == searchChar1) & (text.charAt(i + 1) == searchChar1)) {
                int firstCharIndex = i;
                int j = i + 2;
                while (text.charAt(j) != searchChar3) {
                    j++;
                }
                int lastCharIndex = j;
                text.delete(firstCharIndex, lastCharIndex);
                j=0;
            } else {
                i++;
            }
        }
        return text;
    }

}
