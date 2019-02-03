package by.it.skosirskiy.jd02_02_old;




import java.util.Deque;
import java.util.LinkedList;

class DequeBuyer {

    private static Deque<Buyer> q = new LinkedList<>();

    static synchronized void add(Buyer buyer) {
        q.addLast(buyer);
    }

    static synchronized Buyer poll() {
        return q.pollFirst();
    }

    static synchronized int getSize() {
        return q.size();
    }
}
