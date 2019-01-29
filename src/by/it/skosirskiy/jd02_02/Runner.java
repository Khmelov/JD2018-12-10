package by.it.skosirskiy.jd02_02;



import java.util.ArrayList;
import java.util.List;

public class Runner {
    static List<Thread> threads = new ArrayList<>();
    public static void main(String[] args) {
        openMarket();
        marketWorkingTime();
        System.out.println("Market closed");
    }

    private static void marketWorkingTime() {
        int number = 0;

        for (int i = 1; i <= 2; i++) {
            Thread cashier = new Thread(new Cashier(i));
            threads.add(cashier);
            cashier.start();
        }

        for (int time = 1 ;; time++) {
            if (time % 60 <= 30) {
                if ((Dispatcher.counterBuyerInShop <= time + 10)&& Dispatcher.marketOpened()) {
                    int count = Util.getRandom(5);
                    for (int i = 0; i < count; i++) {
                        Buyer buyer = new Buyer(++number);
                        threads.add(buyer);
                        buyer.start();
                    }
                }
                else Util.sleep(1000);
                }
            else {
                    if ((Dispatcher.counterBuyerInShop >= 40 + (30 - time))&& Dispatcher.marketOpened()) {
                        Util.sleep(1000);
                    } else {
                        int count = Util.getRandom(2);
                        for (int i = 0; i < count; i++) {
                            Buyer buyer = new Buyer(++number);
                            threads.add(buyer);
                            buyer.start();
                        }
                    }
                }
            if(Dispatcher.planComplete()) {for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } break;}
            }

//        while (Dispatcher.marketOpened()) {
//            System.out.println(Dispatcher.counterBuyer+" "+Dispatcher.counterBuyerInShop);
//            Util.sleep(100);
//        }
        }

    private static void openMarket() {
        System.out.println("Market opened");
        Goods.getPriceList();
    }
}