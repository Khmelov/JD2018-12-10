package by.it.lyakhova.jd02_02;

public class Dispatcher {

    static final int K_SPEED = 10;
    private static volatile int counterBuyerInShop = 0;
    private static volatile int counterBuyerComplete = 0;
    private static final int plan = 100;

    static final Object DISPCASHIER = new Object();

    static volatile int totalSum = 0;

    //private static volatile int counterOpenCashier = 0;


    private static final Object MONITOR = new Object();
    static final Object CONSOL = new Object();

    static int getCounterBuyerInShop(){
        return counterBuyerInShop;
    }

    static int getCounterBuyerComplete(){
        return counterBuyerComplete;
    }


    static void newBuyer(){
        synchronized (MONITOR) {
            counterBuyerInShop++;
            //System.out.println(counterBuyerInShop + " shop shop disp");
        }
    }

    static void buyerComplete(){
        synchronized (MONITOR) {
            counterBuyerInShop--;
            //System.out.println(counterBuyerInShop + " shop shop disp");
            counterBuyerComplete++;
            //System.out.println(counterBuyerComplete + " complete disp");
        }
    }

    static boolean planComplete(){
        synchronized (MONITOR) {
            return counterBuyerComplete >= plan;
        }

    };
    static boolean marketOpened(){
        synchronized (MONITOR) {
            return counterBuyerInShop + counterBuyerComplete < plan;
        }
    }

    /*static void openCashier(){
        counterOpenCashier++;
    }

    static void closeCashier(){
        counterOpenCashier--;
    }

    static int getCounterOpenCashier(){
        return counterOpenCashier;
    }*/
}
