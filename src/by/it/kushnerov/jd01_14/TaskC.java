package by.it.kushnerov.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir") + "/src/"
                + by.it.kushnerov.jd01_14.TaskC.class.getName().replace(by.it.kushnerov.jd01_14.TaskC.class.getSimpleName(), "")
                .replace(".", "/");
        String pathDirs = (new File(dir)).getParent();
        File dirs = new File(pathDirs);
        File result = new File(getPath(by.it.kushnerov.jd01_14.TaskC.class, "resultTaskC.txt"));
        try (PrintWriter out = new PrintWriter(new FileWriter(result))) {
            printToConsoleAndFile(dirs, out, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToConsoleAndFile(File dirs, PrintWriter out, File result) {
        File[] listDirs = dirs.listFiles();
        if (listDirs != null) {
            for (File catalog : listDirs) {
                if (catalog.isFile()) {
                    System.out.println("   file:" + catalog.getName());
                    out.println("   file:" + catalog.getName());
                } else if (catalog.isDirectory()) {
                    System.out.println("dir:" + catalog.getName());
                    out.println("dir:" + catalog.getName());
                    printToConsoleAndFile(catalog, out, result);
                }
            }
        }
    }

    static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }
}
