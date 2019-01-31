package by.it.moroz.jd02_02;

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
    private static volatile int counterBuyerInMarket=0;
    private static volatile int counterBuyerComplete=0;
    private static final Object MONITOR = new Object();

    private static final int plan = 100;

    static boolean planComplete(){
        synchronized (MONITOR) {
            return counterBuyerComplete == plan;
        }
    }

    static boolean marketOpened(){
        synchronized (MONITOR) {
            return counterBuyerInMarket + counterBuyerComplete < plan;
        }

    }

    static void newBuyer(){
        synchronized (MONITOR) {
            counterBuyerInMarket++;
        }
    }

    static void buyerComplete(){
        synchronized (MONITOR) {
            counterBuyerInMarket--;
            counterBuyerComplete++;
        }
    }

    static int getCounterBuyerInMarket(){
        return counterBuyerInMarket;
    }

}
