package by.it.moroz.jd02_05;

import java.io.*;

public class Native2ascii {

    public static void main(String[] args) {

        File directory = new File(System.getProperty("user.dir") +
                "/src/by/it/moroz/jd02_05");
        if(directory.exists() && directory.isDirectory()){
            File[] files = directory.listFiles();
            if (files!=null) {
                for (File file : files) {
                    if (file.getName().contains(".txt")) {
                        process(file);
                    }
                }
            }
        } else {
            System.out.println("Incorrect path");
        }
    }

    private static void process(File file) {
        File fileOut = new File(file.getAbsolutePath().replace(".txt", ".properties"));
        try(BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut))){
            while (br.ready()){
                int i = br.read();
                if(i<128)
                    bw.write(i);
                else
                    bw.write("\\u"+String.format("%04x",i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

