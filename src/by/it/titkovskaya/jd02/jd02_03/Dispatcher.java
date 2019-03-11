package by.it.titkovskaya.jd02.jd02_03;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    static final int K_SPEED = 100;
    private static volatile AtomicInteger counterBuyerInShop = new AtomicInteger(0);
    private static volatile AtomicInteger counterBuyerComplete = new AtomicInteger(0);
    private static volatile AtomicInteger  pensionersCounter = new AtomicInteger(0);
    static AtomicInteger cashierNumber = new AtomicInteger(0);
    private static volatile AtomicInteger  totalGoodsCounter = new AtomicInteger(0);
    private static volatile AtomicInteger  totalTimeSpent = new AtomicInteger(0);

    static Semaphore semaphoreTakingBaskets = new Semaphore(50);
    static Semaphore semaphoreChoosingGoods = new Semaphore(20);
    static Semaphore semaphoreQueue = new Semaphore(30);
    static Semaphore semaphoreToPrint = new Semaphore(1);
    static Semaphore semaphoreRevenue = new Semaphore(1);


    private static final int plan = 100;

    static AtomicInteger getCounterBuyerInShop() {
        return counterBuyerInShop;
    }

    static AtomicInteger getPensionersCounter() {
        return pensionersCounter;
    }

    static AtomicInteger getCounterBuyerComplete() {
        return counterBuyerComplete;
    }

    static AtomicInteger getTotalGoodsCounter() {
        return totalGoodsCounter;
    }

    static AtomicInteger getTotalTimeSpent() {
        return totalTimeSpent;
    }

    static void newPensioner() {
        pensionersCounter.incrementAndGet();
    }

    static void newBuyer() {
        counterBuyerInShop.incrementAndGet();
    }

    static void buyerComplete() {
        counterBuyerInShop.decrementAndGet();
        counterBuyerComplete.incrementAndGet();
    }

    static boolean planComplete() {
        return counterBuyerComplete.get() >= plan;
    }

    static boolean marketOpened() {
        return counterBuyerInShop.get() +
                counterBuyerComplete.get()
                < plan;
    }

}
