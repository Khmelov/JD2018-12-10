package by.it.titkovskaya.jd02.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class DequeBuyer {

    private static volatile BlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30);
    private static volatile BlockingDeque<Buyer> dequePrior = new LinkedBlockingDeque<>(30);

    static int getDequeSize() {
        return deque.size() + dequePrior.size();
    }

    static void add(Buyer buyer, boolean pensioner) {
        if (pensioner) {
            try {
                dequePrior.put(buyer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                deque.put(buyer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static Buyer poll() {
        if (dequePrior.size() > 0) return dequePrior.poll();
        else if (deque.size() > 0) return deque.poll();
        else return null;
    }
}

/*
    static Comparator<Buyer> buyerComparator = (o1, o2) -> {
        if (o1.pensioner&&!o2.pensioner) return -1;
        if (!o1.pensioner&&o2.pensioner) return 1;
        if (o1.pensioner&&o2.pensioner){
            if (o1.timeToQueue>=o2.timeToQueue){
                return 1;
            } else return -1;
        }
        if (!o1.pensioner&&!o2.pensioner){
            if (o1.timeToQueue>=o2.timeToQueue){
                return 1;
            } else return -1;
        }
        return 0;
    };

    private static PriorityBlockingQueue<Buyer> deque = new PriorityBlockingQueue<>(30,buyerComparator);

    static int getDequeSize(){
        return deque.size();
    }

    static void add(Buyer buyer, boolean pensioner) {
        deque.put(buyer);
    }

    static Buyer poll() {
        return deque.poll();
    }

 */