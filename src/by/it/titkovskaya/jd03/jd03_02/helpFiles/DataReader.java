package by.it.titkovskaya.jd03.jd03_02.helpFiles;

import by.it.titkovskaya.jd03.jd03_01.Runner;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReader {
    public static void main(String[] args) {
        Pattern pattern2 = Pattern.compile("(?<=DEFAULT, )[^)]+");
        Matcher matcher;
        StringBuilder builder = new StringBuilder();
        StringBuilder dataBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader
                    (new File(new Path().getPath(Runner.class, "titkovskaya.sql"))));
            while (reader.ready()){
                builder.append(reader.readLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        matcher=pattern2.matcher(builder);
        while (matcher.find())
            dataBuilder.append(matcher.group().replace("'","\"")).append("\n");

        System.out.println(dataBuilder);

    }
}
