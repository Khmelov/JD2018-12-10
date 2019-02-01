package by.it.skosirskiy.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class DequeBuyer {

    private static BlockingDeque<Buyer> q = new LinkedBlockingDeque<>(20);

    static void add(Buyer buyer) {
            q.addLast(buyer);
    }

    static Buyer poll() {
            return q.pollFirst();
    }
}
