package by.it.titkovskaya.jd01.jd01_06;

/*
Сформировать и вернуть в методе String slow (String text) из случайных слов
исходного текста строку String минимум в сто тысяч символов путем конкатенации. Слова
должны быть «склеены» через один пробел. Затем:
• В методе main: определить время работы метода slow (удобно использовать
System.nanoTime() или аналог); вывести полученный текст и время работы метода slow в
милисекундах на консоль.
• Ускорить процесс с StringBuilder (сделать новый метод String fast (String text),
ВАЖНО: его итог должен быть таким как в slow до буквы). В main повторить вывод.
 */

import java.util.Random;

public class TaskC2 {

    public static void main(String[] args) {

        String[] text = Poem.text.trim().split("[^а-яА-ЯёЁ]+");
        StringBuilder sb = new StringBuilder();
        String result = new String();
        while (result.length() <= 100000) {
            result = sb.append(" ").append(text[new Random().nextInt(text.length)]).toString();
        }

        long t = System.nanoTime();
        System.out.println(slow(result));
        long dtSlow = (System.nanoTime() - t) / 1000;

        t = System.nanoTime();
        System.out.println(fast(result));
        long dtFast = (System.nanoTime() - t) / 1000;

        System.out.println("slow dt=" + dtSlow);
        System.out.println("fast dt=" + dtFast);
        System.out.println("Отличие в скорости dtSlow/dtFast=" + dtSlow / dtFast);
    }

    private static String slow(String text) {
        String slowResult = new String();
        slowResult = slowResult.concat(" ").concat(text);
        return slowResult;
    }

    private static String fast(String text) {
        StringBuilder sb = new StringBuilder();
        String fastResult = sb.append(" ").append(text).toString();
        return fastResult;
    }
}

/*
        System.out.println(words.length);

        String slowText = slow(text);
        System.out.println(slowText);

 */