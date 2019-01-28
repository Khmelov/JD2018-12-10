package by.it.migunko.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {
    static String getDirContent(File[] files) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                sb.append("dir:");
                sb.append(files[i].getName());
                sb.append("\n");
                sb.append(getDirContent(files[i].listFiles()));
            } else if (files[i].isFile()) {
                sb.append("file:");
                sb.append(files[i].getName());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/by/it/migunko/";
        File directory = new File(path);

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(
                        new File(path+"jd01_14/", "resultTaskC.txt")))
        ) {

            System.out.println("dir:..");
            String directoryContent = getDirContent(directory.listFiles());

            System.out.println(directoryContent);

            bw.write(directoryContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
