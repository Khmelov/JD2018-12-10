package by.it.dziomin.jd02_01;


import java.time.LocalTime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

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

        while (market.isOpened()) {
//            System.out.println("DISPATCH " + currentSec + " created: " + LocalTime.now());
            dispatch(market);
            Util.sleep(1000);
            currentSec.incrementAndGet();
        }

        try {
            market.join();
            for (Buyer buyer : buyerList) {
                buyer.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void dispatch(Market market) {
        new Thread(() -> {
            int n = createBuyerCount(market.getBuyerCount());
            for (int i = 0; i < n; i++) {
                boolean pens = Util.getRandom(1, 4) == 4;
                Buyer buyer = new Buyer("Buyer " + buyerCount.incrementAndGet(), pens, market);
                buyerList.add(buyer);
                System.out.println(buyer.getName() + " created");
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
