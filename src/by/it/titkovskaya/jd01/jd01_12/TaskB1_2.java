package by.it.titkovskaya.jd01.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
TaskB1. Нужно ввести с консоли текст на английском языке до строки “end” (100 и
более слов).
 Для каждого слова с помощью коллекций подсчитать частоту его встречаемости.
 Вывести все различные слова формате слово=частота. Слова, отличающиеся
регистром букв, считать различными. isn't или don’t – одно слово.
 */
public class TaskB1_2 {
    public static void main(String[] args) {
        String line;
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (!(line = scanner.nextLine()).equals("end")) {
            sb.append(" ").append(line);
        }
        String[] keys = sb.toString().split("[^A-z']+");
        Map<String, Integer> map = new HashMap<>();
        for (String key : keys) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else map.put(key, map.remove(key) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}

/*
Iterator<Map.Entry<String,Integer>> itr = map.entrySet().iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
 */