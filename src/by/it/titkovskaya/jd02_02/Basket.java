package by.it.titkovskaya.jd02_02;

import java.util.HashMap;

public class Basket {

    static HashMap<Buyer, String> buyersBaskets = new HashMap<>();

    static void putToBasket (Buyer buyer,String goodsToBasket) {
        buyersBaskets.put(buyer,goodsToBasket);
    }
}
