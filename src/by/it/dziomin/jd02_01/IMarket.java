package by.it.dziomin.jd02_01;

import java.util.Set;

public interface IMarket {

    Basket getBasket();

    void addBuyer(Buyer buyer);

    void removeBuyer(Buyer buyer);

    Set<String> getGoodsNames();

    Good getGood(String name);

    boolean isOpened();

    int getBuyerCount();
}
