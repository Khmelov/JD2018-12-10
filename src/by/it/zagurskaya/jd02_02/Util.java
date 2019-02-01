package by.it.zagurskaya.jd02_02;

public class Util {

    static Integer getRandom(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    static int getRandom(int max) {

        return getRandom(0, max);
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
