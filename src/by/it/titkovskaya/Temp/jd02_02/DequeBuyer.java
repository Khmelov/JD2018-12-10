package by.it.titkovskaya.Temp.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class DequeBuyer {

    private static volatile Deque<Buyer> deque = new LinkedList<>();
    private static volatile Deque<Buyer> dequePrior = new LinkedList<>();

    static int getTotalDequeSize(){
        return deque.size()+dequePrior.size();
    }

    static synchronized void add(Buyer buyer, boolean pensioner) {
        if (!pensioner) {
            deque.addLast(buyer);
        } else {
            dequePrior.addLast(buyer);
        }
        synchronized (Dispatcher.QUEUE_MON){
            Dispatcher.QUEUE_MON.notify();
        }
    }

    static synchronized Buyer poll() {
        if (dequePrior.size() > 0){
            return dequePrior.pollFirst();
        } else if (deque.size()>0)
            return deque.pollFirst();
        else return null;
    }
}
