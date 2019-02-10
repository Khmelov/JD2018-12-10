package by.it.lyakhova.jd02_03;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static Map<String, Integer> goods = new HashMap<>();



    void setGoods(){
        for (int i = 1; i < 50; i++) {
            goods.put("good №" + i, (int)(Math.random()*500));
        }
    }


    protected static Map.Entry<String, Integer> getGoods(){
        int randomGood = Util.getRandom(1, goods.size()-1);
        for (Map.Entry<String, Integer> entry: goods.entrySet()) {
            if (entry.getKey().equals("good №" + randomGood)) return entry;
        }
        return null;
    }




}
