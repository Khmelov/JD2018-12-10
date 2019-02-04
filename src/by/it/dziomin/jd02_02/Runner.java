package by.it.dziomin.jd02_02;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

import static by.it.dziomin.jd02_02.Constants.MAX_BUYERS_COUNT;

public class Runner {

    private static AtomicLong currentSec = new AtomicLong();

    private static Queue<Buyer> buyerList = new ConcurrentLinkedQueue<>();
    private static AtomicLong buyerCount = new AtomicLong();

    public static void main(String[] args) {

        Market market = new Market("Market");
        market.start();
        while (!market.isOpened()) {
            Util.sleep(10);
        }

        while (market.isOpened() && buyerCount.get() < MAX_BUYERS_COUNT) {
            dispatch(market);
            Util.sleep(1000);
            currentSec.incrementAndGet();
        }

        try {
            market.join();
//            System.out.println("Market joined");
            for (Buyer buyer : buyerList) {
                buyer.join();
//                System.out.println(buyer.getName() + " joined");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void dispatch(Market market) {
        new Thread(() -> {
            int n = createBuyerCount(market.getBuyerCount());
            for (int i = 0; i < n && buyerCount.get() < MAX_BUYERS_COUNT; i++) {
                boolean pens = Util.getRandom(1, 4) == 4;
                Buyer buyer = new Buyer("Buyer " + buyerCount.incrementAndGet(), pens, market);
                buyerList.add(buyer);
//                System.out.println(buyer.getName() + " created");
                buyer.start();
            }
        }).start();
    }


    private static int createBuyerCount(int N) {

        long t = currentSec.get() % 60;

        if (t < 30 && N < t + 10) {
            return Util.getRandom(1, 2);
        } else if (t >= 30 && N <= 40 + (30 - t)) {
            return Util.getRandom(1, 2);
        } else {
            return 0;
        }
    }
}
