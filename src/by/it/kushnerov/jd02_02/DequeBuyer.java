package by.it.kushnerov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class DequeBuyer {

    private static final Object MONITOR = new Object();

    private static Deque<Buyer> q = new LinkedList<>();

    static void add(Buyer buyer){
        synchronized (MONITOR){
        q.addLast(buyer);
        }
    }

    static Buyer poll(){
        synchronized (MONITOR){
        return q.pollFirst();
        }
    }
}
