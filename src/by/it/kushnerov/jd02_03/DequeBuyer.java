package by.it.kushnerov.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class DequeBuyer {

    private static BlockingDeque<Buyer> q = new LinkedBlockingDeque<>(20);

    static synchronized void add(Buyer buyer) {
            q.addLast(buyer);
    }

    static synchronized Buyer poll() {
            return q.pollFirst();
    }
}
