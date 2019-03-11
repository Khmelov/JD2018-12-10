package by.it.titkovskaya.jd01.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
В классе TaskB нужно выполнить следующие шаги:
 В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
препинания и слов
 Вывести результат на консоль в виде одной строки:
words=123, punctuation marks=15
 Продублировать вывод в консоль в файл resultTaskB.txt
 */

public class TaskB_1 {

    private static int wordsCount=0;
    private static int punctuationCount=0;

    public static void main(String[] args) {
        long t = System.nanoTime();
        File file = new File(TaskA.getPath(TaskB_1.class, "text.txt"));
        readFileAndFindMatches(file);
        System.out.println("words=" + wordsCount);
        System.out.println("punctuation marks=" + punctuationCount);
        printToFile(wordsCount, punctuationCount);
        System.out.println(System.nanoTime() - t);
    }

    private static void readFileAndFindMatches(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                String line = reader.readLine();
                wordsCount=findMatches(line, "[^?!()\":;,.\\s-]+", wordsCount);
                punctuationCount=findMatches(line, "[?!()\":;,.-]+", punctuationCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findMatches(String line, String regex, int matchesCount) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            matchesCount++;
        }
        return matchesCount;
    }

    private static void printToFile(int wordsCount, int punctCount) {
        String result = TaskA.getPath(TaskB_1.class, "resultTaskB.txt");
        File resultTask = new File(result);
        try (PrintWriter out = new PrintWriter(new FileWriter(resultTask))) {
            out.println("words=" + wordsCount);
            out.println("punctuation marks=" + punctCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
