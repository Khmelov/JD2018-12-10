package by.it.subach.jd01_14;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        String simpleName = clazz.getSimpleName();
        path = path.replace(simpleName, "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }

    public static void main(String[] args) {
        String path = getPath(TaskB.class, "text.txt");
        String text = readFromFile(path);
        String result = countWordsAndPunct(text);
//        output to console
        System.out.println(result);
//        output to file
        printStringToFile(result);

    }

    public static void printStringToFile(String str){
        try (FileOutputStream fos = new FileOutputStream(getPath(TaskB.class, "resultTaskB.txt"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos)))
        {
            bw.write(str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String countWordsAndPunct(String text) {
        String regWord = "[а-яА-яЁё]+";
        int wordsCount = 0;
        int punctCount = 0;
        Pattern pattern = Pattern.compile("([а-яА-ЯёЁ]+)|(\\.{3})|(\\p{Punct})");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            if (matcher.group().matches(regWord)) wordsCount++;
            else
                punctCount++;
        }
        return "words=" + wordsCount + ", " + "punctuation marks=" + (punctCount);
    }

    public static String readFromFile(String path) {
        StringBuilder result = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}

