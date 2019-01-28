package by.it.skosirskiy.jd02_01;



import java.util.ArrayList;
import java.util.List;

public class Runner {
    static List<Buyer> buyers = new ArrayList<>();
    public static void main(String[] args) {

        openMarket();
        marketWorkingTime();
        System.out.println("Market closed");
    }

    private static void marketWorkingTime() {
        int number = 0;
        for (int time = 1; time <= 120; time++) {
            if (time % 60 <= 30) {
                if (Dispatcher.counterBuyer <= time + 10) {
                    int count = Util.getRandom(4); // bilo 2
                    for (int i = 0; i < count; i++) {
                        Buyer buyer = new Buyer(++number);
                        buyers.add(buyer);
                        Dispatcher.counterBuyer++;
                        buyer.start();
                        Util.sleep(1000);
                    }
                }
                else Util.sleep(1000);
                } else {
                    if (Dispatcher.counterBuyer >= 40 + (30 - time)) {
                        Util.sleep(1000);
                    } else {
                        int count = Util.getRandom(2);
                        for (int i = 0; i < count; i++) {
                            Buyer buyer = new Buyer(++number);
                            buyers.add(buyer);
                            Dispatcher.counterBuyer++;
                            buyer.start();
                            Util.sleep(1000);


                        }

                    }
                }


                while (Dispatcher.counterBuyer > 0) {
                    Util.sleep(100);
                }
            }
        }



    private static void openMarket() {
        System.out.println("Market opened");
        Goods.getPriceList();
    }
}