package by.it.titkovskaya.Temp.jd02_02;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    static final int K_SPEED = 100;
    private static int counterBuyerInShop = 0;
    private static int counterBuyerComplete = 0;
    private static int pensionersCounter = 0;
    static AtomicInteger cashierNumber = new AtomicInteger(0);
    private static volatile double totalRevenueCounter = 0;
    static int totalGoodsCounter = 0;
    static double totalTimeSpent = 0;
    private static final Object MON = new Object();
    static final Object QUEUE_MON = new Object();
    static final Object CONSOLE_MON = new Object();
    static final Object GOODS_MON = new Object();
    static final Object REVENUE_MON = new Object();
    static final Object TIME_MON = new Object();

    private static final int plan = 100;

    static int getCounterBuyerInShop() {
        return counterBuyerInShop;
    }

    static int getCounterBuyerComplete() {
        return counterBuyerComplete;
    }

    static double getTotalRevenueCounter() {
        synchronized (REVENUE_MON) {
            return totalRevenueCounter;
        }
    }

    static void setTotalRevenueCounter(double revenuePerBuyer) {
        synchronized (REVENUE_MON) {
            Dispatcher.totalRevenueCounter += revenuePerBuyer;
        }
    }

    static void newPensioner() {
        synchronized (MON) {
            pensionersCounter++;
        }
    }

    static int getPensionersCounter() {
        return pensionersCounter;
    }

    static void newBuyer() {
        synchronized (MON) {
            counterBuyerInShop++;
        }
    }

    static void buyerComplete() {
        synchronized (MON) {
            counterBuyerInShop--;
            counterBuyerComplete++;
        }
    }

    static boolean planComplete() {
        synchronized (MON) {
            return counterBuyerComplete == plan;
        }
    }

    static boolean marketOpened() {
        synchronized (MON) {
            return counterBuyerInShop +
                    counterBuyerComplete
                    < plan;
        }
    }

}
