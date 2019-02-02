package by.it.skosirskiy.Test;

import java.util.HashMap;

public class Backet {

    public static HashMap<Buyer, HashMap<String, Integer>> cheсkHashMap=new HashMap<>();

    public static void chooseGoods(Buyer buyer) {
         HashMap<String, Integer> bufHashMap= new HashMap<>();
         int count=Util.getRandom(1,4);
        for (int i = 0; i < count; i++) {
            synchronized (buyer) {
                String randomGoodsKey = Goods.getRandomGoodsKey();
                Integer value = Goods.getGoodsValue(randomGoodsKey);
                bufHashMap.put(randomGoodsKey, value);
            }
            }
        synchronized (buyer){
            cheсkHashMap.put(buyer, bufHashMap);}//список товаров на каждого покупателя

    }

}
