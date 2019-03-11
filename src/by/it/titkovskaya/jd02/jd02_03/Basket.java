package by.it.titkovskaya.jd02.jd02_03;

import java.util.concurrent.ConcurrentHashMap;

public class Basket {

    static ConcurrentHashMap <Buyer, String> buyersBaskets = new ConcurrentHashMap<>();

    static void putToBasket (Buyer buyer, String goodsToBasket) {
        buyersBaskets.put(buyer,goodsToBasket);
    }
}
