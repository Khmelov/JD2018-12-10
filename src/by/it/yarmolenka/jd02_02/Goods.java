package by.it.yarmolenka.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Goods {

    private Map<String, Double> priceList = new HashMap<>();     // список товаров магазина

    //во время создания экзмпляра заполняем список товаров магазина
    Goods() {
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

    //геттер размера списка товаров магазина
    int getPriceListSize() {
        return priceList.size();
    }

    //геттер цены товара из списка товаров магазина
    double getPrice(String goods) {
        if (priceList.containsKey(goods)){
            return (int) Math.round(priceList.get(goods)*10)/10.0;
        } else
            return 0.0;
    }
}
