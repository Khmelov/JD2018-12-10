package by.it.zagurskaya.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class DequeBuyer {

    private static volatile BlockingDeque<Buyer> q = new LinkedBlockingDeque<>(30);

    static synchronized void add(Buyer buyer) {
        q.addLast(buyer);
    }

    static Buyer poll() {
        return q.pollFirst();
    }

    public static int getDequeBuyerSize() {
        return q.size();
    }
}
