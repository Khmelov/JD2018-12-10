package by.it.lyakhova.jd01_15;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        String path = System.getProperty("user.dir") +"/src/by/it/lyakhova/jd01_15";

        System.out.println(path);

        File folder = new File(path);

        while (!((line = scanner.nextLine()).equalsIgnoreCase("end"))){


            if (line.equalsIgnoreCase("cd ..")){
                path = folder.getParent();
                folder = new File(path);
                System.out.println(path);
            }

            else if (line.contains("cd ")){
                    line = line.replaceAll("cd\\s+", "");
                    String[] list = folder.list();
                if (list!=null) {
                    for (String element : list) {
                        if (element.equals(line)) {
                            path = path + "/" + element;
                            folder = new File(path);
                            System.out.println(path);
                            break;
                        }
                    }
                }

                }
            else if (line.contains("dir")){
                System.out.println("Содержимое папки " + folder.getName());
                watchFiles(path);
            }
        }
    }

    private static void watchFiles(String dir){
        File path = new File(dir);
        Date date;
        String text = "";
        if(path.isDirectory()){
            File[] list = path.listFiles();
            if (list!=null) {
                for (File item : list) {
                    if (item.isDirectory()) {
                        long time = item.lastModified();
                        date = new Date(time);
                        text =item.getName();
                        //System.out.println(date.toString() +" " + " <DIR> " + text);
                        System.out.printf("%7tB %<2te,  %<tY  %<tT %<Tp %-7s%-10s\n", date, "<DIR>", text);

                    } else {
                        long time = item.lastModified();
                        text =item.getName();
                        date = new Date(time);
                        //System.out.println(date.toString() +"        " + text);
                        System.out.printf("%7tB %<2te,  %<tY  %<tT %<Tp %-7s%-10s\n", date, "", text);
                    }
                }
            }
        }
    }
}
