package by.it.subach.jd01_14;

import java.io.*;

public class TaskC {
    private static StringBuilder sb = new StringBuilder();

    private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        String simpleName = clazz.getSimpleName();
        path = path.replace(simpleName, "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }

    public static void main(String[] args) {
        File currentDir = new File(getPath(TaskC.class, ""));
        String parentDir = currentDir.getParent();
        printStringToFile("");
        String str = viewDir(parentDir);
        System.out.println(str);
        printStringToFile(str);
    }

    private static String viewDir(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                sb.append("dir:").append(file.getName()).append("\n");
                viewDir(file.getPath());
            } else
                sb.append("file:").append(file.getName()).append("\n");
        }
        return sb.toString();
    }

    private static void printStringToFile(String str) {
        try (FileOutputStream fos = new FileOutputStream(getPath(TaskC.class, "resultTaskC.txt"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
