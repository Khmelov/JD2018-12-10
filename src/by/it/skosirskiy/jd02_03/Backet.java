package by.it.skosirskiy.jd02_03;


import java.util.HashMap;

class Backet {



    static HashMap<Buyer, HashMap<String, Integer>> checkHashMap=new HashMap<>();


    static void addGoodsInBacket(Buyer buyer) {

        HashMap<String, Integer> hashMap=new HashMap<>();
        int count= Util.getRandom(1,4);
        for (int i = 0; i < count; i++) {
            String buf= Goods.getRandomGoodsKey();
            hashMap.put(buf,Goods.getGoodsValue(buf));
            checkHashMap.put(buyer, hashMap);
        }

    }
}
