package by.it.yarmolenka.jd02_05;

import by.it.yarmolenka.MathCalc.GetPath;

import java.io.*;

public class JavaConverter {
    public static void main(String[] args) {
        String path = GetPath.getPath(JavaConverter.class);
        File f = new File(path);
        if (f.exists() && f.isDirectory()) {
            File[] files = f.listFiles();
            if (files != null)
                for (File file : files) {
                    if (file.getName().contains(".txt"))
                        process(file);
                }
        } else System.out.println("There is no such package");
    }

    private static void process(File file) {
        File prop = new File(file.getAbsolutePath()
                .replace(".txt", ".properties"));
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             PrintWriter writer = new PrintWriter(new FileWriter(prop))) {
            while (reader.ready()) {
                int read = reader.read();
                if (read < 128) writer.write(read);
                else {
                    writer.printf("\\u%04x", read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
