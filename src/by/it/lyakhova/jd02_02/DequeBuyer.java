package by.it.lyakhova.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class DequeBuyer {

    private static Deque<Buyer> q = new LinkedList<>();
    private static Deque<Buyer> p = new LinkedList<>();


    static synchronized void add(Buyer buyer, boolean pensioneer){
        if (pensioneer) p.addLast(buyer);
        else q.addLast(buyer);
    }

    static synchronized Buyer pollPensioneer(){
        return p.pollFirst();
    }

    static synchronized Buyer pollBuyer(){
        //the same to  - synchronized(DequeBuyer.class)
        return q.pollFirst();
    }

    static synchronized int getSizeBuyer(){
        return q.size();
    }

    static synchronized int getSizePensioneer(){
        return p.size();
    }

    static synchronized int getFullQueue(){
        return (q.size()+p.size());
    }



}
