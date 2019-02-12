package by.it._tasks_.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {

    public static void main(String[] args) {

        long timeSlow = System.nanoTime();
        slow(Poem.text);
        long totalSlow = (System.nanoTime() - timeSlow) / 1000000;
        System.out.println(totalSlow + "мс");

        long timeFast = System.nanoTime();
        fast(Poem.text);
        long totalFast = (System.nanoTime() - timeFast) / 1000000;
        System.out.println(totalFast + "мс");
    }

    private static String[] wordArray(String text){
        Pattern sentence = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = sentence.matcher(text);

        int count = 0; //how many are words in the poem
        while (matcher.find()) count++;
        //Systems.out.println(count);

        String[] arrSentence = new String[count];
        matcher.reset();

        int i = 0;
        while (matcher.find()){
            arrSentence[i] = matcher.group().replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
            i++;
        }
        return arrSentence;
    }

    static String slow(String text) {
        String[] words = wordArray(text);
        Random r = new Random(1223456);
        String array = new String();
        while (array.length() < 100000) {
            array = array.concat(words[r.nextInt(words.length)]).concat(" ");
        }
        return array;
    }

    static String fast(String text){
        String[] words = wordArray(text);
        Random r = new Random(1223456);
        StringBuilder builder = new StringBuilder(100000);
        while (builder.length() < 100000) {
            builder.append(words[r.nextInt(words.length)]).append(' ');
        }
        return builder.toString();
    }

}
