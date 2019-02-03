package by.it.skosirskiy.jd02_03;

import by.it.skosirskiy.Test3.Good;

import java.util.HashMap;

public class Backet {


    public static HashMap<Buyer, HashMap<String, Integer>> cheсkHashMap=new HashMap<>();


    public static void addGoodsInBacket(Buyer buyer) {

        HashMap<String, Integer> hashMap=new HashMap<>();
        int count= Util.getRandom(1,4);
        for (int i = 0; i < count; i++) {
            String buf= Goods.getRandomGoodsKey();
            hashMap.put(buf,Goods.getGoodsValue(buf));
            cheсkHashMap.put(buyer, hashMap);
        }

    }
}
