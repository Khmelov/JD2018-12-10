package by.it.dziomin.jd01_15;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class TaskC {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = "";

        String path = System.getProperty("user.dir") + "\\src\\" + TaskB.class.getCanonicalName();
        path = path.replace(".", File.separator);
        path = path.replace("TaskB", "");
//        System.out.println(path);

        File currentDir = new File(path);
        while (!str.equalsIgnoreCase("end")) {
            str = sc.nextLine();
            if (str.equals("cd")) {
                System.out.println(currentDir);
            }
            if (str.equals("cd..")) {
                currentDir = currentDir.getParentFile();
                System.out.println(currentDir);
            }
            if (str.startsWith("cd ")) {

                str = str.replace("cd ", "");
                System.out.println(currentDir);
                currentDir = new File(currentDir + File.separator + str);
                System.out.println(currentDir);

            }
            if (str.equals("dir")) {
                System.out.println(currentDir);
                File[] files = currentDir.listFiles();

                if (files != null) {
                    for (File file : files) {
                        Date date = new Date();
                        date.setTime(file.lastModified());
                        String dir = "";
                        if (file.isDirectory()) {
                            dir = "<DIR>";
                        }
                        System.out.printf("%-30s%-10s%-20s\n", date, dir, file.getName());
                    }
                }

            }

        }

    }


}
