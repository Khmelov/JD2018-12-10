package by.it.titkovskaya.jd01.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
В классе TaskC нужно выполнить следующие шаги:
 Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
формате file:имя_файла или dir:имя_каталога.
 Продублировать вывод в консоль в файл resultTaskC.txt
 */

public class TaskC {

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir") + "/src/"
                + TaskC.class.getName().replace(TaskC.class.getSimpleName(), "")
                .replace(".", "/");
        String pathDirs = (new File(dir)).getParent();
        File dirs = new File(pathDirs);
        File result = new File(TaskA.getPath(TaskC.class, "resultTaskC.txt"));
        try (PrintWriter out = new PrintWriter(new FileWriter(result))) {
            showContentAndPrintToFile(dirs, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showContentAndPrintToFile(File dirs, PrintWriter out) {
        File[] listDirs = dirs.listFiles();
        if (listDirs != null) {
            for (File catalog : listDirs) {
                if (catalog.isFile()) {
                    System.out.println("   file:" + catalog.getName());
                    out.println("   file:" + catalog.getName());
                } else if (catalog.isDirectory()) {
                    System.out.println("dir:" + catalog.getName());
                    out.println("dir:" + catalog.getName());
                    showContentAndPrintToFile(catalog, out);
                }
            }
        }
    }
}
