package by.it.moroz.jd02_01;

import java.util.*;

class GoodsInMarket {

    static Map<String, Integer> goods = new HashMap<>();

    static void checkTheGoods (Map<String, Integer> goods){
        goods.put("Bread", 2);
        goods.put("Milk", 3);
        goods.put("Cheese", 10);
        goods.put("Tea", 7);
        goods.put("Cake", 15);
        goods.put("Ice cream", 3);
        goods.put("Meat", 23);
        goods.put("Fish", 12);
        goods.put("Cottage cheese", 2);
        goods.put("Sausage", 18);
    }
    static String choseRandomGood (Map<String, Integer> goods){
        Random random = new Random();
        List<String> keys = new ArrayList<>(goods.keySet());
        return keys.get(random.nextInt(keys.size()));
    }

}
