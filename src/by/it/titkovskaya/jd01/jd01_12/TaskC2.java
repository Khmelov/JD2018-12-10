package by.it.titkovskaya.jd01.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
TaskC2. Попробуйте решить заново задачу TaskA2 для любого количества
множеств на входе метода, а также для различных типов чисел в каждом из
множеств (generics).
 В main покажите работоспособность решения.
 */
public class TaskC2 {
    public static void main(String[] args) {
        Integer[] arr1 = {0, 8, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7};
        Integer[] arr2 = {9, 9, 9, 8, 8, 4, 4, 5, 6, 6, 7, 7};
        Integer[] arr3 = {5, 13, 6, 12, 7, 10, 15, 20};

        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(arr2));
        Set<Integer> set3 = new TreeSet<>(Arrays.asList(arr3));
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);

        Set<Integer> union = getUnion(set1, set2, set3);
        System.out.println(union);
        Set<Integer> cross = getCross(set1, set2, set3);
        System.out.println(cross);

        Double[] arr4 = {84.0, 56.0, 71.0, 75.0, 15.0, 20.0, 71.0, 83.0, 29.0, 99.0, 59.0};
        Double[] arr5 = {29.0, 99.0, 26.0, 45.0, 59.0, 15.0, 89.0, 31.0, 69.0, 14.0, 33.0};
        Double[] arr6 = {58.0, 7.0, 86.0, 75.0, 15.0, 15.0, 65.0, 95.0, 58.0, 59.0};
        Double[] arr7 = {58.0, 7.0, 86.0, 59.0, 15.0};

        Set<Double> set4 = new HashSet<>(Arrays.asList(arr4));
        Set<Double> set5 = new TreeSet<>(Arrays.asList(arr5));
        Set<Double> set6 = new TreeSet<>(Arrays.asList(arr6));
        Set<Double> set7 = new TreeSet<>(Arrays.asList(arr7));
        System.out.println(set4);
        System.out.println(set5);
        System.out.println(set6);
        System.out.println(set7);

        Set<Double> union2 = getUnion(set4, set5, set6, set7);
        System.out.println(union2);
        Set<Double> cross2 = getCross(set4, set5, set6, set7);
        System.out.println(cross2);
    }

    private static <T extends Number> Set<T> getUnion(Set<T>... set) {
        Set<T> result = new HashSet<>(set[0]);
        for (Set<T> element : set) {
            result.addAll(element);
        }
        return result;
    }

    private static <T extends Number> Set<T> getCross(Set<T>... set) {
        Set<T> result = new HashSet<>(set[0]);
        for (Set<T> element : set) {
            result.retainAll(element);
        }
        return result;
    }
}
