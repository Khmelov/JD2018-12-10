package by.it.yarmolenka.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Goods {

    private Map<String, Integer> priceList = new HashMap<>();     // список товаров магазина

    //во время создания экзмпляра заполняем список товаров магазина
    Goods() {
        priceList.put("хлеб", 7);
        priceList.put("молоко", 13);
        priceList.put("кефир", 14);
        priceList.put("колбаса", 40);
        priceList.put("сыр", 31);
        priceList.put("мандарины", 21);
        priceList.put("чай", 34);
        priceList.put("батон", 6);
        priceList.put("огурцы", 22);
        priceList.put("пельмени", 31);
        priceList.put("яйца", 22);
    }

    //геттер размера списка товаров магазина
    int getPriceListSize() {
        return priceList.size();
    }

    //геттер цены товара из списка товаров магазина
    int getPrice(String goods) {
        return priceList.getOrDefault(goods, 0);
    }
}
