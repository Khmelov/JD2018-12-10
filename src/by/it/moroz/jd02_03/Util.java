package by.it.moroz.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

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
    private static AtomicInteger counterBuyerInMarket=new AtomicInteger(0);
    private static AtomicInteger counterBuyerComplete=new AtomicInteger(0);
    private static AtomicInteger counterCashiers = new AtomicInteger(0);
    private static AtomicInteger proceeds = new AtomicInteger(0);

    private static final int plan = 100;

    static boolean planComplete(){
            return counterBuyerComplete.get() == plan;
    }

    static boolean marketOpened(){
            return counterBuyerInMarket.get() + counterBuyerComplete.get() < plan;

    }

    static void newBuyer(){
            counterBuyerInMarket.incrementAndGet();

    }

    static void buyerComplete(){
            counterBuyerInMarket.decrementAndGet();
            counterBuyerComplete.incrementAndGet();
    }

    static int getCounterBuyerInMarket(){
            return counterBuyerInMarket.get();
    }

    static int getCountCashiers() {
            return counterCashiers.get();
    }

    static void newCashier(){
            counterCashiers.incrementAndGet();
    }

    static void moreProceeds(int cash){
            proceeds.getAndAdd(cash);
    }

    static int getProceeds(){
            return proceeds.get();
    }

}
