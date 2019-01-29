package by.it.skosirskiy.jd02_02;

class Dispatcher {

    static final int K_SPEED = 100;

    private static volatile int counterBuyerInShop = 0;
    private static volatile int counterBuyerComplete = 0;
    private static final int plan = 100;
    private static final Object MON = new Object();



    static int getCounterBuyerInShop() {
        synchronized (MON) {
            return counterBuyerInShop;
        }
    }

    static boolean planComplete() {
        synchronized (MON) {
            return counterBuyerComplete >= plan;
        }
    }


    static void buyerComplete() {
        synchronized (MON) {
            counterBuyerInShop--;
            counterBuyerComplete++;
        }
    }

    static boolean marketOpened() {
        synchronized (MON) {
            return counterBuyerInShop +
                    counterBuyerComplete
                    < plan;
        }
    }
    static void newBuyer() {
        synchronized (MON) {
            counterBuyerInShop++;
        }
    }
}

