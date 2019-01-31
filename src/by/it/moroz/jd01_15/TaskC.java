package by.it.moroz.jd01_15;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        String startPos = getPath();
        System.out.println(startPos);
        File start = new File(startPos);
        Scanner scanner = new Scanner(System.in);
        String command;
        while (!((command = scanner.nextLine()).equalsIgnoreCase("end"))) {
            if (command.equals("cd ..")) {
                System.out.println(start.getParentFile().toPath());
            }
            if (command.equals("dir")) {
                Path path = Paths.get(startPos);
            }
            if (command.matches("cd [A-Za-z\\p{Punct}]+")) {
                String[] com = command.split(" ");
                System.out.println(com[1]);
                File pos = new File(startPos + File.separator + com[1]);
                File allPos = new File(com[1]);
                if (pos.exists()){
                    System.out.println(pos.getPath());
                } else if (allPos.exists()){
                    System.out.println(allPos.getPath());
                } else System.out.println("Системе не удается найти указанный путь");
            }

        }
    }

    private static String getPath() {
        String path = TaskC.class.getName().replace(".", File.separator).replace(TaskC.class.getSimpleName(), "");
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
    }
}
