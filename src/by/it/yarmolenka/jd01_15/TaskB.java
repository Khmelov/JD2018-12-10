package by.it.yarmolenka.jd01_15;

import java.io.*;

/**
 * комментарий комментарий комментарий комментарий комментарий комментарий
 * комментарий комментарий комментарий комментарий комментарий комментарий
 * комментарий комментарий комментарий комментарий комментарий комментарий
 */
public class TaskB {
    public static void main(String[] args) {
        String path = TaskA.getPath(TaskB.class) + "TaskB.java";
        StringBuilder sb = removeComments(path);
        System.out.println(sb);
        String path2 = TaskA.getPath(TaskB.class) + "TaskB.txt";
        stringBuilderToFile(sb, path2);
    }

    private static void stringBuilderToFile(StringBuilder sb, String path2) {
        try (FileWriter fw = new FileWriter(path2)) {
            fw.append(sb);
                    /*фантазия таксебе фантазия таксебе фантазия таксебе фантазия таксебе
                    фантазия таксебе фантазия таксебе фантазия таксебе фантазия таксебе
                    фантазия таксебе фантазия таксебе фантазия таксебе фантазия таксебе
                     */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder removeComments(String path) {
        StringBuilder sb = new StringBuilder();
//        boolean read = true;
        try (RandomAccessFile file = new RandomAccessFile(path, "r")) {
            for (long i = 0; i < file.length(); ) { //перебор
                file.seek(i);
                char ch = (char) file.read();
                if (ch != '/') sb.append(ch);
                else {
                    i++;
                    char c = (char) file.read();
                    if (c == '/') {
                        while ((char) file.read() != '\n') {
                            i++;
                        }
                        /*фантазия таксебе фантазия таксебе фантазия таксебе фантазия таксебе
                    фантазия таксебе фантазия таксебе фантазия таксебе фантазия таксебе
                    фантазия таксебе фантазия таксебе фантазия таксебе фантазия таксебе
                     */
                    } else if (c == '*') {
                        char b, d;
                        do {
                            do{
                                i++;
                                b = (char) file.read();
                            } while (b != '*');
                            i++;
                            d = (char) file.read();
                        } while (d !='/');
                    } else {
                        i--;
                        file.seek(i);
                        sb.append((char) file.read());
                    }
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }
}
