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
public class TaskC1 {
    public static void main(String[] args) {
        Long t = System.nanoTime();
        Scanner scanner = new Scanner(System.in);
        String line;
        Map<Long, String> map = new HashMap<>();
        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")){
            map.put(System.nanoTime(),line);
        }

        Iterator<String> iterator = map.values().iterator();
        Set<String> mapValues = new HashSet<>();
        while (iterator.hasNext()){
            if (!mapValues.add(iterator.next())){
                iterator.remove();
            }
        }
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        Long tA = System.nanoTime() - t;
        System.out.println(tA);
    }
}
/*
ttt
ggg
yyy
sss
ddd
ttt
nnn
hhh
ttt
ddd
sss
aaa
qqq
eee
mmm
iii
aaa
zzz
zzz
mmm
xxx
ppp
ooo
end

 */