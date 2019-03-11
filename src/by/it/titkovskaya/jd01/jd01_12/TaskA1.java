package by.it.titkovskaya.jd01.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
TaskA1. Создайте в классе TaskA1 приватное поле - список оценок учеников (с
помощью ArrayList).
 Заполните его из метода main случайными оценками (1-10).
 Удалите неудовлетворительные оценки (1-3) из списка с помощью
нестатического метода void clearBad(List<Integer> grades) с итератором.
 Выведите на консоль оба варианта списка (до и после удаления).
 */
public class TaskA1 {

    private List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 20; i++) {
            int grade = (int) (Math.random() * 10) + 1;
            instance.grades.add(grade);
        }
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);
    }

    private void clearBad(List<Integer> gr) {
        Iterator<Integer> iterator = gr.iterator();
        while (iterator.hasNext()) {
            Integer currentGrade = iterator.next();
            if (currentGrade < 4)
                iterator.remove();
        }
    }
}
