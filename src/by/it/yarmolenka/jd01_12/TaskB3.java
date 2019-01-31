package by.it.yarmolenka.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        int n = 4096;
        ArrayList<String> list1 = new ArrayList<>();
        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list1.add(String.valueOf(i));
            list2.add(String.valueOf(i));
        }
        long check1 = System.nanoTime();
        String process = process(list1);
        long check2 = System.nanoTime();
        String process1 = process(list2);
        long check3 = System.nanoTime();
        String process2 = processQueue(list2);
        long check4 = System.nanoTime();
        System.out.println("Оставшийся элемент - " + process);
        long time1 = check2-check1;
        System.out.println("Время обработки через ArrayList " + time1 + " нс");
        System.out.println("Оставшийся элемент - " + process1);
        long time2 = check3-check2;
        System.out.println("Время обработки через LinkedList " + time2 + " нс");
        System.out.println("Оставшийся элемент - " + process2);
        long time3 = check4-check3;
        System.out.println("Время обработки через DequeBuyer " + time3 + " нс");
    }

    private static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1) {
            for (int i = 0; i < 2; i++) {
                if (iterator.hasNext()) iterator.next();
                else return process(peoples, i);
            }
            iterator.remove();
        }
        return peoples.get(0);
    }

    private static String process(ArrayList<String> peoples, int k) {
        Iterator<String> iterator = peoples.iterator();
        for (int i = k; i < 2; i++)
            if (iterator.hasNext()) iterator.next();
            else return process(peoples, i);
        iterator.remove();
        while (peoples.size() != 1) {
            for (int i = 0; i < 2; i++) {
                if (iterator.hasNext()) iterator.next();
                else return process(peoples, i);
            }
            iterator.remove();
        }
        return peoples.get(0);
    }

    private static String processQueue(LinkedList<String> peoples){
        while (peoples.size()!=1){
            peoples.offerLast(peoples.pollFirst());
            peoples.remove();
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1) {
            for (int i = 0; i < 2; i++) {
                if (iterator.hasNext()) iterator.next();
                else return process(peoples, i);
            }
            iterator.remove();
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples, int k) {
        Iterator<String> iterator = peoples.iterator();
        for (int i = k; i < 2; i++)
            if (iterator.hasNext()) iterator.next();
            else return process(peoples, i);
        iterator.remove();
        while (peoples.size() != 1) {
            for (int i = 0; i < 2; i++) {
                if (iterator.hasNext()) iterator.next();
                else return process(peoples, i);
            }
            iterator.remove();
        }
        return peoples.get(0);
    }
}
