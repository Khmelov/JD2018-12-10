package by.it.titkovskaya.jd01.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        String reg = "[а-яёА-ЯЁ]{4,}";
        System.out.println(Poem.text);
        Pattern pattern=Pattern.compile(reg);
        StringBuilder sb=new StringBuilder(Poem.text);
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            int start = matcher.start();
            sb.setCharAt(start+3,'#');
            if (matcher.end()-matcher.start()>=7)
                sb.setCharAt(start+6,'#');
        }
        System.out.println(sb);
    }
}
