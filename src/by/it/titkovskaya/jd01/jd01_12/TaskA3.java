package by.it.titkovskaya.jd01.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
TaskA3. В main класса TaskA3 вводите список чисел с клавиатуры до ввода
слова “end”.
 Переставьте отрицательные элементы списка чисел в конец, а положительные —
в начало списка, сохраняя их порядок относительно друг друга.
 Выведите список на консоль методом коллекции toString().
 */
public class TaskA3 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pos = 0;
        while (true) {
            String input = scanner.next();
            if (input.equals("end")) break;
            Integer value = Integer.valueOf(input);
            if (value < 0)
                list.add(value);
            else if (value == 0)
                list.add(pos, value);
            else list.add(pos++, value);
        }
        System.out.println(list);
    }
}
