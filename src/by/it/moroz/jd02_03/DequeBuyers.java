package by.it.moroz.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class DequeBuyers {

    static BlockingDeque<Buyer> buyerDeque = new LinkedBlockingDeque<>(30);

    static BlockingDeque<Buyer> pensionerDeque = new LinkedBlockingDeque<>(30);

    static void add (Deque<Buyer> buyers, Buyer buyer){
            buyers.addLast(buyer);
    }

    static Buyer poll(Deque<Buyer> buyers){
            return buyers.pollFirst();
    }

    static int getCountAllBuyer (){
        return buyerDeque.size()+pensionerDeque.size();
    }

}
