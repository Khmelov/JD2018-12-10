package by.it.subach.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Util {
    static String [] products = {"Картофель", "Капуста", "Морковь", "Помидоры", "Огурцы", "Чеснок", "Лук", "Свекла", "Хлеб"};

    static Map<String, Integer> priceList = new HashMap<>();

    static int getRandom (int min, int max){
        return min + (int) (Math.random() * (max - min +1));
    }

    static int getRandom(int max){
        return getRandom(0, max);
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void fillPriceList(Map<String, Integer> priceList){
        for (String product : products) {
            Integer price = Util.getRandom(1, 10);
            priceList.put(product, price);
        }
    }



}
