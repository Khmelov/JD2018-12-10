package by.it.yarmolenka.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TaskC {

    public static void main(String[] args) throws IOException {
        String pathToRoot = TaskA.getPath(TaskC.class);
        File f = new File(pathToRoot);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        System.out.println(f.getAbsolutePath());
        while (!((input = reader.readLine()).equalsIgnoreCase("end"))) {
            f = inputAction(f, input);
        }
    }

    private static File inputAction(File f, String input) throws IOException {
        if (input.equals("cd ..")) {
            f = f.getParentFile();
            System.out.println(f.getAbsolutePath());
        } else if (input.matches("cd [a-zA-Z0-9._]+")) {
            f = new File (f.getAbsolutePath() + File.separator + input.substring(3));
            f = checkExistence(f);
        } else if (input.equals("dir")) {
            writeAboutDirectory(f);
        } else {
            System.err.println("Wrong Input");
            System.out.println(f.getAbsolutePath());
        }
        return f;
    }

    private static void writeAboutDirectory(File f) throws IOException {
        System.out.println("Содержимое папки " + f.getAbsolutePath() + "\n");
        File[] files = f.listFiles();
        int sumFiles = 0, sumDirs = 0;
        if (files != null)
            for (File file : files) {
                writeAboutFile(file);
                if (file.isFile()) sumFiles++;
                else sumDirs++;
            }
        writeAboutThisDir(f, sumFiles, sumDirs);
    }

    private static File checkExistence(File f) {
        if (f.exists()) System.out.println(f.getAbsolutePath());
        else {
            System.err.println("Wrong directory");
            f = f.getParentFile();
            System.out.println(f.getAbsolutePath());
        }
        return f;
    }

    private static void writeAboutThisDir(File f, int sumFiles, int sumDirs) throws IOException {
        BasicFileAttributes attributes = Files.readAttributes(
                Paths.get(f.getAbsolutePath()), BasicFileAttributes.class);
        System.out.printf("               %d файлов  %,d байт%n", sumFiles, attributes.size());
        System.out.printf("               %d папок  %,d байт свободно%n%n", sumDirs, f.getFreeSpace());
    }

    private static void writeAboutFile(File file) throws IOException {
        Path path = Paths.get(file.getAbsolutePath());
        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
        FileTime fileTime = attr.creationTime();
        Date date = new Date(fileTime.toMillis());
        DateFormat formatter = new SimpleDateFormat("dd.MM.YYYY  HH:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+3:00"));
        String dateFormatted = formatter.format(date);
        String dir = file.isDirectory() ? "<DIR>" : "";
        String name = file.getName();
        long size = attr.size();
        if (file.isFile()) System.out.printf("%s   %,15d   %s\n", dateFormatted, size, name);
        else System.out.printf("%s   %-15s   %s\n", dateFormatted, dir, name);
    }
}
