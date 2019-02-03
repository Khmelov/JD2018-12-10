package by.it.skosirskiy.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED = 10000;
     private static volatile AtomicInteger counterBuyerInShop = new AtomicInteger(0);
    private static volatile AtomicInteger counterBuyerComplete = new AtomicInteger(0);

    static void reset(){
        counterBuyerInShop.set(0);
        counterBuyerComplete.set(0);
    }
    private static final int plan = 100;

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
