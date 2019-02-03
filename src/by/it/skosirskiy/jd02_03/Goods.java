package by.it.skosirskiy.jd02_03;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Goods {


    private static HashMap<String, Integer> priceList = new HashMap<>();
    private static List<String> keys;


    static void getPriceList() {
        priceList.put("milk", 100);
        priceList.put("butter", 300);
        priceList.put("bread", 110);
        priceList.put("apple", 50);
        priceList.put("juice", 130);
        priceList.put("pork", 500);
        priceList.put("chicken", 350);
        keys = new ArrayList<>(priceList.keySet());
    }
    static String getRandomGoodsKey() {
        String keysRandom=keys.get(Util.getRandom(0,keys.size()-1));

        return keysRandom;
    }
    static Integer getGoodsValue(String key) {

        Integer valueRandom=priceList.get(key);
        return valueRandom;
    }

}

