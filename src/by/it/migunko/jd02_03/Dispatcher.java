package by.it.migunko.jd02_03;
import java.util.concurrent.atomic.AtomicInteger;
class Dispatcher {
    private static final Integer planCount = 100;
    private static AtomicInteger countBuyerInShop = new AtomicInteger(0);
    private static AtomicInteger countBuyerComplete = new AtomicInteger(0);

    static void addBuyer() {
        countBuyerInShop.incrementAndGet();
    }

    static void completeBuyer() {
        countBuyerInShop.decrementAndGet();
        countBuyerComplete.incrementAndGet();
    }

    static boolean openedMarket(){
        return (countBuyerComplete.get()<planCount);
    }

    static boolean planComplete() {
        return (countBuyerComplete.get() + countBuyerInShop.get()) >= planCount;
    }

}
