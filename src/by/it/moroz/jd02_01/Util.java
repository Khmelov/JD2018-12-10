package by.it.moroz.jd02_01;

class Util {

    static int getRandom (int from, int to){
        return from+(int)(Math.random()*(to-from+1));
    }


    static void sleep(int time){
        try {
            Thread.sleep(time/K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final int K_SPEED=100;

    static int counterBuyer=0;


}
