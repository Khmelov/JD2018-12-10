package by.it.lyakhova.jd02_03;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    static final int K_SPEED = 10;
    private static volatile AtomicInteger counterBuyerInShop = new AtomicInteger(0);
    private static volatile AtomicInteger counterBuyerComplete = new AtomicInteger(0);
    private static final int plan = 100;
    static Semaphore semaphoreConsol = new Semaphore(1);

    static volatile AtomicInteger totalSum = new AtomicInteger(0);

    static final Object CONSOL = new Object();

    static int getCounterBuyerInShop(){
        return counterBuyerInShop.get();
    }

    static int getCounterBuyerComplete(){
        return counterBuyerComplete.get();
    }


    static void newBuyer(){
            counterBuyerInShop.incrementAndGet();
    }

    static void buyerComplete(){
            counterBuyerInShop.decrementAndGet();
            counterBuyerComplete.incrementAndGet();
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    static boolean planComplete(){
            return counterBuyerComplete.get() >= plan;
    }
    static boolean marketOpened(){
            return counterBuyerInShop.get() + counterBuyerComplete.get() < plan;
    }

}
