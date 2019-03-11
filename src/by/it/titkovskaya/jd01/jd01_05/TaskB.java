package by.it.titkovskaya.jd01.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y = y + (pow(7, a)) - cos(x);
            }
            System.out.printf("При a=%.2f Сумма y=%e\n", a, y);
        }
    }

    private static void step2() {
        for (double x = -5.5; x < 2; x += 0.5) {
            if (x / 2 <= -2 || x / 2 > 0.2)
                System.out.printf("При x/2=%.2f вычисления не определены\n", x / 2);
            else {
                double b = 0;
                double a = 0;
                if (x / 2 > -2 && x / 2 <= -1)
                    b = sin(x * x);
                if (x / 2 > -1 && x / 2 > 0.2)
                    b = cos(x * x);
                if (x / 2 == 0.2)
                    b = cos(x * x) / sin(x * x);
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%.2f a = %e\n", x / 2, a);
            }
        }
    }
}
