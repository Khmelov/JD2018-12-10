package by.it.yarmolenka.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Goods {
    static Map<String, Double> priceList = new HashMap<>();

    static void loadPriceList() {
        priceList.put("хлеб", 0.7);
        priceList.put("молоко", 1.3);
        priceList.put("кефир", 1.4);
        priceList.put("колбаса", 4.0);
        priceList.put("сыр", 3.1);
        priceList.put("мандарины", 2.1);
        priceList.put("чай", 3.4);
        priceList.put("батон", 0.6);
        priceList.put("огурцы", 2.2);
        priceList.put("пельмени", 3.1);
        priceList.put("яйца", 2.2);

    }
}
