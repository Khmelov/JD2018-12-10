package by.it.zagurskaya.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    static final int K_SPEED = 100;
    private static volatile AtomicInteger counterBuyerInShop = new  AtomicInteger(0);
    private static volatile AtomicInteger counterBuyerComplete = new AtomicInteger(0);
//    private static final boolean[] BUYER_PLACES = new boolean[20];
//    private static final Semaphore SEMAPHORE = new Semaphore(20, true);
//    private static final Object MON = new Object();
    private static final int plan = 100;

    static void newBuyer() {
//        synchronized (MON) {
            counterBuyerInShop.incrementAndGet();
//        }
    }

    static void buyerComplete() {
//        synchronized (MON) {
            counterBuyerInShop.decrementAndGet();
            counterBuyerComplete.incrementAndGet();
//        }
    }

    static boolean planComplete() {
//        synchronized (MON) {
            return counterBuyerComplete.get()>= plan;
//        }
    }

    static boolean marketOpened() {
//        synchronized (MON) {
            return counterBuyerInShop.get() +
                    counterBuyerComplete.get()
                    < plan;
//        }
    }
}
