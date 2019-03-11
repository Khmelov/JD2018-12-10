package by.it.titkovskaya.jd01.jd01_14;

/*
В классе TaskB нужно выполнить следующие шаги:
 В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
препинания и слов
 Вывести результат на консоль в виде одной строки:
words=123, punctuation marks=15
 Продублировать вывод в консоль в файл resultTaskB.txt
 */

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB_2 {

    public static void main(String[] args) {
        long t = System.nanoTime();
        File file = new File(TaskA.getPath(TaskB.class, "text.txt"));
        String wordsRegex = "[^?!()\":;,.\\s-]+";
        String punctRegex = "[?!()\":;,.-]+";
        int matchesCount = 0;
        int wordsCount = readFileAndFindMatches(file, wordsRegex, matchesCount);
        int punctuationCount = readFileAndFindMatches(file, punctRegex, matchesCount);
        System.out.println("words=" + wordsCount);
        System.out.println("punctuation marks=" + punctuationCount);
        printToFile(wordsCount, punctuationCount);
        System.out.println(System.nanoTime() - t);
    }

    private static int readFileAndFindMatches(File file, String regex, int matchesCount) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                String line = reader.readLine();
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    matchesCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matchesCount;
    }

    private static void printToFile(int wordsCount, int punctCount) {
        String result = TaskA.getPath(TaskB.class, "resultTaskB.txt");
        File resultTask = new File(result);
        try (PrintWriter out = new PrintWriter(new FileWriter(resultTask))) {
            out.println("words=" + wordsCount);
            out.println("punctuation marks=" + punctCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
