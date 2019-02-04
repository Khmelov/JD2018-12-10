package by.it.migunko.jd02_02;

public class Util {
    private static final int K_SPEED=100;

    static int rnd(int start, int stop) {
        return start + ((int) (Math.random() * (stop - start + 1)));
    }
    static int rnd(int start, int stop, double speed) {
        return (int)((start + ((int) (Math.random() * (stop - start + 1))))*speed);
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
