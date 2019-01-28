package by.it.subach.jd01_15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {

    private static String currentPath = getPath(TaskC.class, "");

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println(currentPath);
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(cd) (\\w+)");

        while (true) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group(2);
                getUp(name);
            } else if (input.equals("cd ..")) {
                getDown(currentPath);
            } else if (input.equals("dir")) {
                viewDirectory(currentPath);
            } else if (input.equals("end")) break;

            else System.out.println("Wrong command!");
        }

    }

    private static void getDown(String path) {
        File file = new File(path);
        currentPath = file.getParent();
        if (currentPath != null) System.out.println(currentPath);
        else System.out.println("You are in the root directory!");
    }

    private static void getUp(String name) {
        currentPath = currentPath + File.separator + name;
        System.out.println(currentPath);
    }

    private static void viewDirectory(String path) throws Exception {
        File file = new File(path);
        String lastModifiedDate = "";
        String isDir = "";
        String name = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy     hh:mm");
        File[] files = file.listFiles();
        for (File f : files) {
            name = f.getName();
            Long l = f.lastModified();
            Date date = new Date(l);
            lastModifiedDate = sdf.format(date);
            if (f.isDirectory())
                isDir = "<DIR>";
            else {
                Long length = f.length();
                isDir = length.toString() + " byte";
            }
            System.out.printf("%s    %10s          %s\n", lastModifiedDate, isDir, name);
//            System.out.println(date);
//            System.out.println(f.getName());
        }

    }


    private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        String simpleName = clazz.getSimpleName();
        path = path.replace(simpleName, "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }
}
