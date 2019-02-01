package by.it.zagurskaya.jd02_02;


import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

class DequeBuyer {

    private static Deque<Buyer> q = new LinkedBlockingDeque<>();

    static synchronized void add(Buyer buyer) {
            q.addLast(buyer);
    }

    static synchronized Buyer poll() {
            return q.pollFirst();
    }

    public static int getDequeBuyerSize() {
        return q.size();
    }
}
