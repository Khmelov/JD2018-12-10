package by.it.yarmolenka.jd02_04.MathCalc;

import java.io.File;

public class GetPath {
    public static String getPath(Class<?> clazz) {
        String path = clazz.getName().replace(".", File.separator)
                .replace(clazz.getSimpleName(), "");
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
    }
}
