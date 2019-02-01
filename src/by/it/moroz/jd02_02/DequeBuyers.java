package by.it.moroz.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class DequeBuyers {

    static Deque<Buyer> buyerDeque = new LinkedList<>();

    static Deque<Buyer> pensionerDeque = new LinkedList<>();

    static synchronized void add (Deque<Buyer> buyers, Buyer buyer){
            buyers.addLast(buyer);
    }

    static synchronized Buyer poll(Deque<Buyer> buyers){
            return buyers.pollFirst();
    }

    static  synchronized int getCountAllBuyer (){
        return buyerDeque.size()+pensionerDeque.size();
    }

}
