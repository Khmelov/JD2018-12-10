package by.it.titkovskaya.jd01.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] words=new String[0];
    private static int[] counters=new int[0];

    private static void processOneWord(String word) {
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (str.equals(word)) {
                counters[i]++;
                return;
            }
        }
        //word is new
        words=Arrays.copyOf(words,words.length+1);
        words[words.length-1]=word;
        counters=Arrays.copyOf(counters,counters.length+1);
        counters[counters.length-1]=1;
    }

    public static void main(String[] args) {
        String reg = "[а-яёА-ЯЁ]+";
        System.out.println(Poem.text);
        Pattern pattern=Pattern.compile(reg);
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            processOneWord(matcher.group());
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]+"="+counters[i]);
        }
    }
}
