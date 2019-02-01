package by.it.zagurskaya.jd02_03;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private Map<String, Double> map = new HashMap<>();

    public void put(Map<String, Double> goods) {
        map.putAll(goods);
    }

    public Map<String, Double> show() {
        return map;
    }

}
