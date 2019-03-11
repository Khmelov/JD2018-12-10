package by.it.titkovskaya.jd01.jd01_05;

import static java.lang.Math.random;

public class TaskC_step2 {
    public static void main(String[] args) {
        step2();
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
