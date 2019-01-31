package by.it.lyakhova.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Goods implements IGoods {

    private static Map<String, Integer> goods = new HashMap<>();

    @Override
    public void setGoods(){
        for (int i = 1; i < 50; i++) {
            goods.put("good №" + i, (int)(Math.random()*500));
        }
    }

    @Override
    public String getGoods(){
        int randomGood = Util.getRandom(1, goods.size()-1);
        for (Map.Entry<String, Integer> entry: goods.entrySet()) {
            if (entry.getKey().equals("good №" + randomGood)) return " put " + entry.getKey() + " price " + entry.getValue() + " ";
        }
        return "no such goods";
    }



}
