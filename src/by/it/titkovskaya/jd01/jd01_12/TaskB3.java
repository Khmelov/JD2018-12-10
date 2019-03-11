package by.it.titkovskaya.jd01.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/*
TaskB3. Скопируйте предыдущую задачу и измерьте на размере задачи в 4096
элемент какой из двух методов работает быстрее. Объясните итог.
 Подумайте, как можно было бы решить задачу в методе
prоcess(LinkedList<String> peoples) без итератора и снижения
быстродействия, используя интерфейсы очередей. Проверьте свою идею.
 */
public class TaskB3 {
    public static void main(String[] args) {
        String text = "Иванов Петров Сидоров Петечкин Васечкин Кукушкин Ватрушкин Козлов Булочкин";
        String[] base = text.split(" ");

        ArrayList<String> peoples1 = new ArrayList<>();
        peoples1.addAll(Arrays.asList(base));
        LinkedList<String> peoples2 = new LinkedList<>(peoples1);
        LinkedList<String> peoples3 = new LinkedList<>(peoples1);
        LinkedList<String> peoples4 = new LinkedList<>(peoples1);
        Long t = System.nanoTime();
        System.out.println(process(peoples1));
        Long tA = System.nanoTime() - t;
        t = System.nanoTime();
        System.out.println(process(peoples2));
        Long tL = System.nanoTime() - t;
        t = System.nanoTime();
        System.out.println(processQueue(peoples3));
        Long tQ = System.nanoTime() - t;
        t = System.nanoTime();
        System.out.println(processDeque(peoples4));
        Long tD = System.nanoTime() - t;
        System.out.println(" Время работы для  ArrayList=" + tA / 1000 + " мкс.");
        System.out.println(" Время работы для LinkedList=" + tL / 1000 + " мкс.");
        System.out.println(" Время работы для  DequeBuyer=" + tQ / 1000 + " мкс.");
        System.out.println(" Время работы для Dequeue=" + tD / 1000 + " мкс.");
    }

    private static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count % 2 == 0) {
                    iterator.remove();
                }
                count++;
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count % 2 == 0) {
                    iterator.remove();
                }
                count++;
            }
        }
        return peoples.get(0);
    }

    private static String processQueue(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            peoples.addLast(peoples.removeFirst());
            peoples.removeFirst();
        }
        return peoples.get(0);
    }

    private static String processDeque(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            peoples.offer(peoples.pollFirst());
            peoples.pollFirst();
        }
        return peoples.get(0);
    }
}
