package by.it.skosirskiy.jd02_01;



import java.util.ArrayList;
import java.util.List;

public class Runner {
    static List<Buyer> buyers = new ArrayList<>();
    public static void main(String[] args) {

        System.out.println("Market opened");
        Dispatcher.getPriceList();
        int buf=0;
        int number = 0;
        for (int time = 1; time <= 120; time++) {
            int count;
            if (Dispatcher.counterBuyer <= 10) {
                count=2;
            }
            else {count = Util.getRandom(2);}
            //while (Util.buyersInMarket(time)) {
                for (int i = 0; i < count; i++) {
                    Buyer buyer = new Buyer(++number);
                    if (Util.getRandom(3) == 0) {
                        Dispatcher.pensioneer = true;
                    } else {
                        Dispatcher.pensioneer = false;
                    }
                    buyers.add(buyer);
                    Dispatcher.counterBuyer++;
                    buf++;
                    buyer.start();

                }
           //}
          //  Util.sleep(1000);
        }

        while (Dispatcher.counterBuyer > 0) {
            Util.sleep(100);
        }
        System.out.println("Market closed");
    }
}
