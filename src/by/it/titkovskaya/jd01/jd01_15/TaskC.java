package by.it.titkovskaya.jd01.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/*
TaskC Нужно реализовать на java приложение - аналог командной строки Windows. Приложение должно
использовать класс File и поддерживать две команды консоли:
 команду cd - смена каталога (посмотрите пример: Win+R → cmd → cd \ → dir ). В тестах проверяются всего
две команды cd .. и cd имя_папки_в_текущем_каталоге
 команду dir - вывод каталога, формат вывода - аналогичный формату в Windows.
 команда end – завершение работы.
 Стартовым каталогом при запуске приложения должна быть папка by.it.ваша_фамилия.jd01_15.
 */
public class TaskC {

    public static void main(String[] args) throws Exception {
        String path = getPath(TaskC.class);
        File file = new File(path);
        cmdAppIsRunning(file);
    }

    private static void cmdAppIsRunning(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(file + ">");
        String input;
        while (!((input = reader.readLine()).equalsIgnoreCase("end"))) {
            if (input.equalsIgnoreCase("dir")) {
                printFileContent(file);
            } else if (input.equalsIgnoreCase("cd..") || input.equalsIgnoreCase("cd ..")) {
                file = file.getParentFile();
                System.out.println(file + ">");
            } else if (input.matches("cd [A-z0-9_ .]+")) {
                file = new File(file, input.replace("cd ",""));
                System.out.println(file + ">");
            } else {
                System.out.println("Данная команда приложением не поддерживается");
                System.out.println(file + ">");
            }
        }
    }

    private static void printFileContent(File file) {
        File[] dirList = file.listFiles();
        int filesCount = 0;
        int dirsCount = 0;
        long fileSize = 0;
        if (dirList != null) {
            for (File content : dirList) {
                fileSize += printContentData(content);
                if (content.isFile()) filesCount++;
                else dirsCount++;
            }
            System.out.printf("%13d %4s %12s %-10s\n", filesCount, "файлов", fileSize, "байт");
            System.out.printf("%13s %4s  %10d %-10s\n", dirsCount + 2, "папок", file.getFreeSpace(), "байт свободно");
            System.out.println();
            System.out.println(file + ">");
        } else System.out.println(file + ">");
    }

    private static Long printContentData(File content) {
        Date date = new Date(content.lastModified());
        DateFormat format = new SimpleDateFormat("dd.MM.YYYY  HH:mm");
        format.setTimeZone(TimeZone.getTimeZone("GMT+3:00"));
        String formattedDate = format.format(date);
        String dir = content.isDirectory() ? "DIR" : "";
        long fileSize = content.length();
        System.out.printf("%-15s %7s %10d %-10s\n", formattedDate, dir, fileSize, content.getName());
        return fileSize;
    }

    private static String getPath(Class<?> clazz) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path;
    }
}
