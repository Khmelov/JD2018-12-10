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

public class TaskC_2 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir") + "/src/"
                + TaskC_2.class.getName().replace(TaskC_2.class.getSimpleName(), "")
                .replace(".", "/");
        String pathDirs = (new File(dir)).getParent();
        File dirs = new File(pathDirs);
        File result = new File(TaskA.getPath(TaskC_2.class, "resultTaskC_2.txt"));
        showContent(dirs);
        printToFile(sb,result);
    }

    private static void showContent(File dirs) {
        File[] listDirs = dirs.listFiles();
        if (listDirs != null) {
            for (File catalog : listDirs) {
                if (catalog.isFile()) {
                    System.out.println("   file:" + catalog.getName());
                    sb.append("   file:").append(catalog.getName()).append("\n");
                } else if (catalog.isDirectory()) {
                    System.out.println("dir:" + catalog.getName());
                    sb.append("dir:").append(catalog.getName()).append("\n");
                    showContent(catalog);
                }
            }
        }
    }

    private static void printToFile(StringBuilder sb, File result) {
        try (PrintWriter out = new PrintWriter(new FileWriter(result))) {
            out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
        System.out.println(dir);
        System.out.println(files.getParent());
        System.out.println(System.getProperty("user.dir"));
        System.out.println(TaskC.class.getSimpleName());
        System.out.println(TaskC.class.getName());
 */