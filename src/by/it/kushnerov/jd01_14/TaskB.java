package by.it.kushnerov.jd01_14;


import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args){
        File file = new File(getPath(TaskB.class, "Task.txt"));
        int wordCount = TaskB.countNumberOfWords(file);
        int pmarksCount = TaskB.countNumberOfPmarks(file);
        printToConsole(wordCount,pmarksCount);
        printToFile(wordCount,pmarksCount);
    }

    private static void printToConsole(int wordCount, int pmarksCount) {
        System.out.println("words="+wordCount+", punctuation marks="+pmarksCount);
    }

    private static void printToFile(int wordCount, int pmarksCount) {
        String txtOut = getPath(TaskB.class,"resultTaskB.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(txtOut))){
            out.println("words="+wordCount+", punctuation marks="+pmarksCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countNumberOfPmarks(File file) {
        int pc = 0;
        try {
            Scanner sc = new Scanner(file);
            Pattern pattern = Pattern.compile("\\p{Punct}+");
            while (sc.hasNext()){
                String line = sc.nextLine();
                Matcher matcher = pattern.matcher(line);
                while (matcher.find())
                    pc++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return pc;
    }

    private static int countNumberOfWords(File file) {
        int wc = 0;
        try {
            Scanner sc = new Scanner(file);
            Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
            while (sc.hasNext()){
              String line = sc.nextLine();
              Matcher matcher = pattern.matcher(line);
              while (matcher.find())
                  wc++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wc;
    }

    private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + path;
        return path + filename;
    }
}
