package by.it.titkovskaya.jd01.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        int n = 20 + (int) (random() * 21);
        double[] masA = new double[n];
        double deltaX = (9 - 5.33) / (n - 1);
        int i = 0;
        int nBCounter = 0;
        for (double x = 5.33; x <= 9; x += deltaX) {
            double z = cbrt(x * x + 4.5);
            masA[i] = z;
            if (masA[i] > 3.5) {
                nBCounter++;
            }
            i++;
        }
        double[] masB = new double[nBCounter];
        int k = 0;
        System.out.println("Массив A[]");
        for (int j = 0; j < masA.length; j++) {
            System.out.printf("%s[% -3d] = %-11.5f", "A", j, masA[j]);
            if ((j + 1) % 5 == 0 || j == masA.length - 1)
                System.out.println();
            if (masA[j] > 3.5) {
                masB[k] = masA[j];
                k++;
            }
        }
        System.out.println();
        System.out.println("Массив B[] из элементов массива A > 3.5");
        double geomMean = 1;
        for (k = 0; k < masB.length; k++) {
            geomMean *= masB[k];
            System.out.printf("%s[% -3d] = %-11.5f", "B", k, masB[k]);
            if ((k + 1) % 5 == 0 || k == masB.length - 1)
                System.out.println();
        }
        geomMean = pow(geomMean, 1.0 / nBCounter);
        System.out.println("Среднее геометрическое=" + geomMean);
    }

    private static void step2() {
        int[] masA = new int[31];
        int masBCounter = 0;
        for (int i = 0; i < masA.length; i++) {
            masA[i] = 103 + (int) (random() * 348);
            if (masA[i] / 10.0 > i)
                masBCounter++;
        }
        int[] masB = new int[masBCounter];
        int k = 0;
        for (int i = 0; i < masA.length; i++) {
            if (masA[i] / 10.0 > i) {
                masB[k] = masA[i];
                k++;
            }
        }

        for (int i = 1; i < masB.length; i++) {
            for (int j = 0; j < masB.length; j++) {
                if (masB[i] < masB[j]) {
                    int buffer = masB[i];
                    masB[i] = masB[j];
                    masB[j] = buffer;
                }
            }
        }
        System.out.println();

        System.out.println("Massive A <index to rows>");
        System.out.println("╔═══════════╦═══════════╦═══════════╦═══════════╦═══════════╗");
        for (int i = 0; i < masA.length; i++) {
            System.out.printf("║ %s[%2d]=%d ","A",i,masA[i]);
            if ((i+1)%5==0) {
                System.out.print("║");
                System.out.println();
                System.out.println("╠═══════════╬═══════════╬═══════════╬═══════════╬═══════════╣");
            }
            if (i==masA.length-1) {
                System.out.print("║           ║           ║           ║           ║");
                System.out.println();
                System.out.println("╚═══════════╩═══════════╩═══════════╩═══════════╩═══════════╝");
            }
        }
        System.out.println();
        System.out.println("Massive B <index to cols>");
        System.out.println("╔═══════════╦═══════════╗");
        for (int i = 0; i <= masB.length/2; i++) {
            if (masB.length%2==0){
                if (i<masB.length/2-2){
                    System.out.printf("║ %s[%2d]=%d ║ %s[%2d]=%d ║", "B", i, masB[i], "B", (i + masB.length / 2), masB[i + masB.length / 2]);
                    System.out.println();
                    System.out.println("╠═══════════╬═══════════╣");
                }
                if (i==masB.length/2-1){
                    System.out.printf("║ %s[%2d]=%d ║ %s[%2d]=%d ║", "B", i, masB[i], "B", (i + masB.length / 2), masB[i + masB.length / 2]);
                    System.out.println();
                    System.out.println("╚═══════════╩═══════════╝");
                }
            }
            if (masB.length%2!=0){
                if (i<masB.length/2){
                    System.out.printf("║ %s[%2d]=%d ║ %s[%2d]=%d ║", "B", i, masB[i], "B", (i + masB.length / 2+1), masB[i + masB.length / 2+1]);
                    System.out.println();
                    System.out.println("╠═══════════╬═══════════╣");
                }
                if (i==masB.length/2){
                    System.out.printf("║ %s[%2d]=%d ║           ║", "B", i, masB[i]);
                    System.out.println();
                    System.out.println("╚═══════════╩═══════════╝");
                }
            }
        }
    }
}
