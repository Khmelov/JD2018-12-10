package by.it.kushnerov.jd02_01;

import java.util.HashMap;

public class Goods {
    public static HashMap<String,Integer> goods = new HashMap<>();

     static void setGoods (){
        goods.put("good 1",100);
        goods.put("good 2",150);
        goods.put("good 3",100);
        goods.put("good 4",200);
        goods.put("good 5",150);
        goods.put("good 6",350);
        goods.put("good 7",250);
        goods.put("good 8",200);
        goods.put("good 9",300);
    }
}
