package by.it.titkovskaya.jd01.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/*
TaskB2. Считалка. В кругу стоят N человек.
 При ведении счета по кругу итератором вычеркивается каждый второй человек,
пока не останется один.
 Нужно составить два метода, моделирующие процесс и возвращающие имя
оставшегося человека:
static String process(ArrayList<String> peoples)
static String process(LinkedList<String> peoples)
 Покажите работу методов в main
 */
public class TaskB2 {
    public static void main(String[] args) {
        String text = "Иванов Петров Сидоров Петечкин Васечкин Кукушкин Ватрушкин Козлов Булочкин";
        String[] base = text.split(" ");

        ArrayList<String> peoples1 = new ArrayList<>();
        peoples1.addAll(Arrays.asList(base));
        LinkedList<String> peoples2 = new LinkedList<>(peoples1);
        System.out.println(process(peoples1));
        System.out.println(process(peoples2));
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
}
