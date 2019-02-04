package by.it.migunko.jd02_01;

import java.util.ArrayList;
import java.util.List;
public class Runner {
    private static List<Buyer> allBuyers=new ArrayList<>();

    public static void main(String[] args) {
        int number=0;
        System.out.println("Магазин открыт");
        for (int time = 0; time < 120; time++) {
            int count=Util.rnd(0,2);
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++number);
                allBuyers.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
        }
        for (Buyer buyer : allBuyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}
