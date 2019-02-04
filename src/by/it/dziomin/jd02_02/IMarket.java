package by.it.dziomin.jd02_02;

import java.util.Set;

public interface IMarket {

    Basket getBasket();

    void addBuyer(Buyer buyer);

    void removeBuyer(Buyer buyer);

    Buyer getBuyerFromQueue();

    Set<String> getGoodsNames();

    Good getGood(String name);

    boolean isOpened();

    int getBuyerCount();
}
