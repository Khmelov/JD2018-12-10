package by.it.moroz.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class DequeBuyers {

   // public class Queue

    private static Deque<Buyer> q = new LinkedList<>();

    static synchronized void add (Buyer buyer){
            q.addLast(buyer);
    }

    static synchronized Buyer poll(){
            return q.pollFirst();
    }
}
