package by.it.naron.jd01_15;

import java.io.*;
import java.io.File;

class Path {

    private Path() {
    }

    static String getPath(Class<?> clazz) {
        String simpleName = clazz.getSimpleName();
        String path = clazz.getName().replace(simpleName, "");
        path = path.replace(".", File.separator);
        String root = System.getProperty("user.dir");
        String result = root + File.separator + "src" + File.separator + path;
        return result;
    }

    static String getPath() {
        return getPath(Path.class);
    }

    static String getPath(String filename) {
        return getPath() + filename;
    }
}


///=======================
//;,l;l,;l,
/*
;l,;l,6588p;l,;
., k
 */


public class TaskB {


    public static void main(String[] args) {
        StringBuilder finsb = new StringBuilder();
        try (BufferedReader rd = new BufferedReader(new FileReader(Path.getPath("TaskB.java")))) {
            while (rd.ready()) {//0 dscscomment ;l,;l,;
                // oneeeescd comment
                char temp = (char) rd.read();
                if (temp == '/') {
                    char a = (char) rd.read();
                    switch (a) {
                        case '/':
                            while (rd.ready()) {
                                char b = (char) rd.read();
                                if (b == '\n') {
                                    break;
                                }
                            }
                            finsb.append("\n");
                            break;
                        case '*':
                            //2cbxfbxfomment
                            while (rd.ready()) {
                                if (((char) rd.read()) == '*' && ((char) rd.read()) == '/') {
                                    break;
                                }
                                /*
                                3 hthfhtfhfhfg
                                 */
                            }
                            break;
                        default:
                            finsb.append(temp);
                            finsb.append(a);
                            break;
                        /*
                        4 comment
                         */
                    }
                    continue;
                }
                /**
                 * JavaDoc
                 */
                finsb.append(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(Path.getPath("TaskB.txt")))) {
            out.write(finsb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(finsb.toString());
    }
}
