package by.it.kushnerov.jd01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class TaskC {
    public static void main(String[] args) {
        String name = System.getProperty("user.dir") + "src/by/it/kushnerov";
        name = name.replace("/",File.separator);
        File fileName = new File(name);
        File[] list = fileName.listFiles();
        assert list != null;
        for (File file : list){
            if (file.isDirectory())
                System.out.println("dir:" + file.getName());
            File files = new File(name,file.getName());
            for (File listFile : Objects.requireNonNull(files.listFiles())){
            }
        }
    }
}
