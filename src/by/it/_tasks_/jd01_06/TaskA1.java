package by.it._tasks_.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        String reg="[а-яА-ЯёЁ]{4,}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(Poem.text);
        StringBuilder sb = new StringBuilder(Poem.text);

        while (matcher.find()){
            /*String word = matcher.group();
            Systems.out.println(word);*/
            int start = matcher.start();
            sb.setCharAt(start+3, '#');
            if ((matcher.end()-matcher.start())>=7) sb.setCharAt(start+6, '#');
        }
        System.out.println(sb);

    }
}
