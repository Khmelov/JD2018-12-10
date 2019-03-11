package by.it.titkovskaya.jd01.jd01_12;

import java.util.*;

/*
TaskC1. Нужно ввести с консоли текст до строки end. Во входном тексте хранятся
наименования некоторых объектов, по одному в строке. Строки иногда
повторяются.
 Построить список C1, элементы которого содержат наименования и уникальные
шифры данных объектов, причем элементы списка должны быть упорядочены по
возрастанию шифров (шифр – некоторое случайное, но гарантированно
уникальное число).
 Затем нужно «сжать» список C1, удаляя дублирующийся наименования объектов.
 Выведите полученный ассоциативный массив в консоль
 */
public class TaskC1_2 {
    public static void main(String[] args) {
        Long t = System.nanoTime();
        Scanner scanner = new Scanner(System.in);
        String line;
        Map<Long, String> map = new TreeMap<>();
        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")){
            map.put(System.nanoTime(),line);
        }
        Collection<String> mapValues = map.values();
        mapValues.removeIf(s -> Collections.frequency(mapValues, s) > 1);
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        Long tA = System.nanoTime() - t;
        System.out.println(tA);
    }
}
/*

1672635027
        String line;
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (!(line = scanner.nextLine()).equals("end")) {
            sb.append(" ").append(line);
        }
        String[] values = sb.toString().split("[^A-zА-яЁё']+");
        Map<Long, String> map = new TreeMap<>();
        for (String value : values) {
            map.put(System.nanoTime() / 1000, value);
        }


Collection<String> mapValues = map.values();
        for (Iterator<String> iterator=mapValues.iterator(); iterator.hasNext();){
            if (Collections.frequency(mapValues,iterator.next())>1){
                iterator.remove();
            }
        }


Iterator<Map.Entry<Long,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Long,String> entry=iterator.next();
            if (map.containsValue(entry.getValue())){
                iterator.remove();
            }
        }
 */