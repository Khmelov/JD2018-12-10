package by.it.zagurskaya.jd02_02;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Showcase {

    private static Map<String, Double> storage = new HashMap<String, Double>() {{
        put("молоко", 1.2);
        put("кефир", 2.4);
        put("хлеб", 1.3);
        put("батон", 2.4);
        put("калбаса", 5d);
        put("сыр", 6d);
        put("вино", 15d);
        put("домино", 2.1);
        put("билет в кино", 10d);
        put("маянез", 3.2);
    }};

    static Map<String, Double> getShowcase() {
        return Collections.unmodifiableMap(storage);
    }

    static Map<String, Double> getGoodByName(String goodName) {
        HashMap<String, Double> returnMap = new HashMap<>();
        returnMap.put(goodName, storage.get(goodName));
        return returnMap;
    }
}
