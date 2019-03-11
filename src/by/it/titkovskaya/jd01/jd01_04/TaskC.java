package by.it.titkovskaya.jd01.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];

        mergeSort(array);
        InOut.printArray(array,"V",4);

        for (int i = 0; i < array.length; i++) {
            if (first == array[i]) {
                System.out.printf("Index of first element=%d\n", i);
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (last == array[i]) {
                System.out.printf("Index of last element=%d\n", i);
                break;
            }
        }
    }

    static void mergeSort(double[] array) {
        if (array.length >= 2) {
            double[] part1 = Arrays.copyOfRange(array, 0, array.length / 2);
            double[] part2 = Arrays.copyOfRange(array, array.length / 2, array.length);
            mergeSort(part1);
            mergeSort(part2);
            for (int i = 0, j = 0, k = 0; i < part1.length || j < part2.length; k++) {
                if (i >= part1.length || (j < part2.length && part1[i] > part2[j])) {
                    array[k] = part2[j];
                    j++;
                } else {
                    array[k] = part1[i];
                    i++;
                }
            }
        }
    }

    static int binarySearch(double[] array, double value) {
        int first = 0;
        int last = array.length - 1;
        int middle = (last + 1) / 2;
        while (array[middle] != value && first != middle && last != middle) {
            if (array[middle] < value) {
                first = middle;
                middle = (first + last) / 2;
            } else {
                last = middle;
                middle = (first + last) / 2;
            }
        }
        if (array[first] == value)
            middle = first;
        if (array[last] == value)
            middle = last;
        if (array[middle] == value)
            System.out.println(middle);
        else
            System.out.println("Element is not found");
        return middle;
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
        double[] actArray = new double[20];
        for (int i = 0; i < actArray.length; i++) {
            actArray[i] = Math.random() * 100 - 50;
        }
        System.out.println("actArray:");
        InOut.printArray(actArray);
        double element=actArray[0];
        System.out.println("element="+element);
        mergeSort(actArray);
        System.out.println("expArray:");
        InOut.printArray(actArray);
        double newIndex=binarySearch(actArray,element);
        System.out.println("index="+newIndex);

    }
}


/*


 */