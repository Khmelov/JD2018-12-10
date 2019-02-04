package by.it.titkovskaya.jd02_02_2.jd02_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Goods {

    private static HashMap<String,Double> goodsList = new HashMap<>();
    static Set<Map.Entry<String, Double>> entries = goodsList.entrySet();

    static void load(){
        goodsList.put("Bl.caviar", 220.50);
        goodsList.put("Red caviar", 12.50);
        goodsList.put("Grapes", 3.20);
        goodsList.put("Prosiutto", 75.70);
        goodsList.put("Jamon", 90.30);
        goodsList.put("Bread", 1.80);
        goodsList.put("Milk", 2.40);
        goodsList.put("Yogurt", 1.65);
        goodsList.put("Cheese", 20.00);
        goodsList.put("Coffee", 9.90);
        goodsList.put("Beverage", 1.80);
        goodsList.put("Tea", 7.70);
        goodsList.put("Chicken", 5.20);
        goodsList.put("Pork", 12.70);
        goodsList.put("Beef", 15.85);
        goodsList.put("Orange", 2.95);
        goodsList.put("Mandarins", 3.25);
        goodsList.put("Bananas", 2.05);
        goodsList.put("Pears", 3.50);
        goodsList.put("Cucumbers", 3.20);
        goodsList.put("Tomato", 4.15);
        goodsList.put("Cake", 14.00);
        goodsList.put("Ice cream", 1.80);
        goodsList.put("Candies", 10.80);
        goodsList.put("Biscuits", 6.80);
    }
}
