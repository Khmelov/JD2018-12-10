package by.it.migunko.jd01_15;

import java.io.File;
import java.util.*;
public class TaskC {
    static String currentFolder;

    static String getStartPath(){
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("user.dir"));
        sb.append(File.separator);
        sb.append("src\\by\\it\\migunko\\jd01_15\\");
        return sb.toString();
    }

    static void folderUp(){
        String[] path = currentFolder.split("\\\\|/");
        if (path.length<2){
            System.out.println(currentFolder);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length-1; i++) {
            sb.append(path[i]);
            sb.append(File.separator);
        }
        currentFolder = sb.toString();
        System.out.println(currentFolder);
    }

    static void folderEnter(String line){
        List<String> l = new ArrayList<>();
        File f = new File(currentFolder);
        for (File file : f.listFiles()) {
            if (file.isDirectory()) l.add(file.getName());
        }
        String name = line.replace("cd ", "");
        if (l.contains(name)){
            currentFolder = currentFolder+name+File.separator;
            System.out.println(currentFolder);
        }
        else System.out.println("Такого каталога не существует!");
    }

    static void dir(){
        Formatter ft = new Formatter();
        File f = new File(currentFolder);
        for (File file : f.listFiles()) {
            Date dataf = new Date(file.lastModified());
            String d = file.isDirectory() ? "DIR" : "";
            String size = file.isFile()? String.valueOf(file.length()) : "";
            ft.format("%s\t%3s\t%10s\t%30s\n",dataf.toString(), d,size,file.getName());
        }
        System.out.println(ft);
    }

    public static void main(String[] args) {
        currentFolder = getStartPath();
        System.out.println(currentFolder);

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите команду cd, dir или end");
        String line;
        while (!(line = sc.nextLine()).equals("end")){
            if (line.equals("cd ..")) {
                folderUp();
                continue;
            }
            if (line.matches("cd .+")) {
                folderEnter(line);
                continue;
            }
            if (line.equals("dir")) dir();
        }
    }
}

