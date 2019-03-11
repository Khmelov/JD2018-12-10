package by.it.titkovskaya.jd01.jd01_04;

import java.util.Arrays;

public class MergeSort {
    static void mergeSort(double[] array) {
        if (array.length >= 2) {
            double[] part1 = Arrays.copyOfRange(array, 0, array.length / 2);
            double[] part2 = Arrays.copyOfRange(array, array.length / 2, array.length);
            mergeSort(part1);
            mergeSort(part2);
            for (int i = 0, j = 0, k = 0; i < part1.length || j < part2.length; k++) {
                if (i >= part1.length || (j < part2.length && part1[i] > part2[j])){
                    array[k] = part2[j];
                    j++;
                }
                else {
                    array[k] = part1[i];
                    i++;
                }
            }
        }
    }
}
