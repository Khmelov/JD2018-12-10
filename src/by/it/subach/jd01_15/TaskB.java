package by.it.subach.jd01_15;
import java.io.*;
/*
this
comment
must
be delete
 */

public class TaskB {

    private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        String simpleName = clazz.getSimpleName();
        path = path.replace(simpleName, "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }

    /**
     *some
     *Java
     *Doc
     *
     *
     */
    public static void main(String[] args) throws IOException {

        String path = getPath(TaskB.class, "TaskB.java");
        System.out.println(path);
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int c;
            while ((c = reader.read()) != -1) {
                if (c == 47) {                  //working too
                    if (reader.read() == 47) {
                       reader.readLine();
                       sb.append("\n");
                    }
                    else {
                        c = reader.read();
                        while (c != 47) {
                            c = reader.read();
                        }
                    }
                }
                if (c != 47)
                    sb.append((char) c);
            }
//comment
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(getPath(TaskB.class, "TaskB.txt")));
        writer.write(sb.toString());
        writer.close();
//comment
        System.out.println(sb);
    }
}


// and here too





