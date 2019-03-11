package by.it.titkovskaya.jd01.jd01_06;

/*
Отформатировать исходный текст с выравниванием по обоим краям. Для этого
добавить дополнительные пробелы между словами, так чтобы ширина строк стала равной, а
число пробелов между словами отличалось не более чем на единицу внутри каждой строки,
причем на единицу большие последовательности пробелов должны идти с начала строки.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\n");
        String[] lines = pattern.split(Poem.text);
        String max = lines[0];
        for (String line : lines) {
            if (max.length() < line.length())
                max = line;
        }
        for (String line : lines) {
            System.out.println(wideLine(line,max.length()));
        }
    }

    private static String wideLine(String line, int length) {
        Pattern pattern = Pattern.compile("[ ]+");
        StringBuilder sb = new StringBuilder(line);
        Matcher matcher = pattern.matcher(sb);
        while (sb.length()<length) {
            int end = 0;
            while (matcher.find(end + 1)&&sb.length()<length) {
                end = matcher.end();
                sb.insert(end, " ");
            }
        }
        line=sb.toString();
        return line;
    }
}


/*
        System.out.println(max);
        System.out.println(max.length()+1);
        Pattern pattern1 = Pattern.compile("[ ]+");
        StringBuilder sb = new StringBuilder("Там русский дух... там Русью пахнет!\n");
        Matcher matcher1 = pattern1.matcher(sb);
        System.out.println(sb);
        while (sb.length()<max.length()) {
            int end = 0;
            while (matcher1.find(end + 1)&&sb.length()<max.length()) {
                end = matcher1.end();
                sb.insert(end, " ");
            }
        }
        System.out.println(sb);
        System.out.println(sb.length());
 */