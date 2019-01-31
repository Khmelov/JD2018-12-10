package by.it.migunko.jd02_01;

import java.util.ArrayList;
import java.util.List;
public class Runner {

    public static void main(String[] args) {
        List<Buyer> buyerList = new ArrayList<>();
        System.out.println("Market open");

        for (int time = 0; time < 100; time++) {
            int buyerCount = Util.random(2);
            for (int i = 0; i < buyerCount; i++) {
                Buyer buyer = new Buyer(Dispatcher.buyerCounter++);
                buyerList.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
        }
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market closed.");
    }
}
