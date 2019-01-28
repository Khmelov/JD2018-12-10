package by.it.yarmolenka.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String path = TaskA.getPath(TaskB.class, "text.txt");
        File f = new File(path);
        StringBuilder sb = stringBuilderFromFile(f);
        int words = countWords(sb);
        int symbols = countSymbols(sb);
        System.out.printf("words=%d, punctuation marks=%d\n", words, symbols);
        WriteResultInFile(words, symbols);
    }

    private static StringBuilder stringBuilderFromFile(File file) {
        StringBuilder fromFile = new StringBuilder();
        String b;
        try (
                BufferedReader br = new BufferedReader(new FileReader(file))
        ) {
            while (!((b = br.readLine()) == null))
                fromFile.append(b).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fromFile;
    }

    private static int countSymbols(StringBuilder sb) {
        int symbols = 0;
        Pattern ps = Pattern.compile("[-.,!?:]+");
        Matcher ms = ps.matcher(sb);
        while (ms.find()) symbols++;
        return symbols;
    }

    private static int countWords(StringBuilder sb) {
        int words = 0;
        Pattern pw = Pattern.compile("[А-Яа-яЁё]+");
        Matcher mw = pw.matcher(sb);
        while (mw.find()) words++;
        return words;
    }

    private static void WriteResultInFile(int words, int symbols) {
        String path1 = TaskA.getPath(TaskB.class, "resultTaskB.txt");
        try (
                PrintWriter printWriter = new PrintWriter(new FileWriter(new File(path1)))
        ) {
            printWriter.printf("words=%d, punctuation marks=%d\n", words, symbols);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
