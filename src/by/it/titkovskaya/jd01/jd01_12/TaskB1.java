package by.it.titkovskaya.jd01.jd01_12;

import java.util.*;

/*
TaskB1. Нужно ввести с консоли текст на английском языке до строки “end” (100 и
более слов).
 Для каждого слова с помощью коллекций подсчитать частоту его встречаемости.
 Вывести все различные слова формате слово=частота. Слова, отличающиеся
регистром букв, считать различными. isn't или don’t – одно слово.
 */
public class TaskB1 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[^A-z'-]");
        for (;;){
            String word=scanner.next();
            if (word.equals("end")) break;
            if (map.containsKey(word)){
                map.put(word, map.get(word)+1);
            } else
                map.put(word,1);
        }
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}

/*
Iterator<Map.Entry<String,Integer>> itr = map.entrySet().iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
 */