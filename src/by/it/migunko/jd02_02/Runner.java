package by.it.migunko.jd02_02;

import java.util.ArrayList;
import java.util.List;
public class Runner {
    static List<Thread> allThreads = new ArrayList<>();
    static int countCashier=0;

    public static void main(String[] args) {
        int number=0;
        System.out.println("Магазин открыт");
        for (int i = 1; i <= 2; i++) {
            Thread thCasier = new Thread(new Cashier(i));
            thCasier.start();
            allThreads.add(thCasier);
            countCashier++;
        }

        while (!Dispatcher.planComplete()) {
            int count = Util.rnd(0, 2);
            for (int i = 0; !Dispatcher.planComplete() && i < count; i++) {
                Buyer buyer = new Buyer(++number);
                Dispatcher.addBuyer();
                allThreads.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
            if( (Math.ceil(BuyerQueue.getSizeQueue()/5)>countCashier) && countCashier<5){
                Thread thCasier = new Thread(new Cashier(++countCashier));
                thCasier.start();
                allThreads.add(thCasier);

            }
        }

        for (Thread t : allThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}
