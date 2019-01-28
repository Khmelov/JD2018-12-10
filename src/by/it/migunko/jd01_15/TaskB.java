package by.it.migunko.jd01_15;
import java.io.*;
/**
 *
 *
 * sdfggf
 * sdf
 */
public class TaskB {
    /* jkgfdg
     */
    private static StringBuilder sb = new StringBuilder();
    private static boolean flag = false;

    public static void main(String[] args) {
        File file = new File(getRoot(), "TaskB.java");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String string;
            while ((string = br.readLine()) != null) {
                sb.append(delComent(string+"\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file2 = new File(getRoot(), "TaskB.txt");
        try (PrintWriter writer = new PrintWriter(file2)) {
            writer.printf(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getRoot() {
        return System.getProperty("user.dir") +
                File.separator +
                "src" +
                File.separator +
                TaskB.class.getName()
                        .replace(TaskB.class.getSimpleName(), "")
                        .replace(".", File.separator);
    }

    private static String delComent(String string) {
        if (flag) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '*') {
                    if (string.charAt(i + 1) == '/') {
                        flag = false;
                        return string.substring(i + 2);
                    }
                }
            }
            return "";
        }
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '/') {
                if (string.charAt(i + 1) == '/') {
                    return string.substring(0, i);
                }
                if (string.charAt(i + 1) == '*') {
                    flag = true;
                    return string.substring(0, i);
                }
            }
        }
        return string;
    }
    /* akjflajlajdff
     */
}