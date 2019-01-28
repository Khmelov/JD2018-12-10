package by.it.dziomin.jd01_15;

import java.io.*;

/**
* TaskB
*
* @author Dziom
*/
public class TaskB {

    private static char star = '\u002A';
    private static char slash = '\u002F';
    private static String inline = new String(new char[]{slash, slash});
    private static String multiline_start = new String(new char[]{slash, star});
    private static String multiline_end = new String(new char[]{star, slash});

    public static void main(String[] args) {
        String classFileName = System.getProperty("user.dir") + "\\src\\" + TaskB.class.getCanonicalName();
        classFileName = classFileName.replace(".", "\\") + ".java";
        String txtFileName = classFileName.replace("TaskB.java", "TaskB.txt");
        /*первый
        многострочный
        комментарий*/
        copyFile(classFileName, txtFileName);
    }

    private static void copyFile(String classFileName, String txtFileName) {
        try (FileInputStream rs = new FileInputStream(classFileName);
             FileOutputStream rw = new FileOutputStream(txtFileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(rs));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(rw))) {
            boolean multiline = false;
            while (br.ready()) {
                //первый однострочный
                String text = br.readLine();
                //второй однострочный
                String temp = text.trim();
                if (!temp.startsWith(inline) && !temp.startsWith(multiline_start) && !temp.endsWith(multiline_end) && !multiline) {
                    bw.write(text);
                    bw.newLine();
                } else if (temp.startsWith(multiline_start)) {
                    if (!temp.endsWith(multiline_end)) {
                        multiline = true;
                    }
                    bw.write(text.replace(temp, ""));
                    bw.newLine();
                } else if (temp.startsWith(inline)) {
                    bw.write(text.replace(temp, ""));
                    bw.newLine();
                } else if (temp.endsWith(multiline_end)) {
                    multiline = false;
                }
                /*второй
        многострочный
        комментарий*/
            }
        } catch (IOException e) {
            /*третий*/
            System.err.println("ошибка чтения" + e.getMessage());
        }
    }
}
