package by.it.kushnerov.jd02_02;

import java.util.*;

public class Goods {
    public static HashMap<String, Integer> goods = new HashMap<>();

    static void setGoods() {
        goods.put("bread", 100);
        goods.put("sweets", 150);
        goods.put("butter", 100);
        goods.put("vegetables", 200);
        goods.put("fruits", 150);
        goods.put("water", 350);
        goods.put("salt", 250);
        goods.put("meat", 200);
        goods.put("fish", 300);
    }

    public String chooseRandom() {
        StringBuffer sb = new StringBuffer();
        int totalSum = 0;
        Random random = new Random();
        int amount = Util.getRandom(1, 4);
        List<String> keys = new ArrayList<>(goods.keySet());
        for (int i = 0; i < amount; i++) {
            String rKey = keys.get(random.nextInt(keys.size()));
            Integer rValue = goods.get(rKey);
            totalSum +=rValue;
            sb.append(rKey).append(" ").append(rValue).append(" ");
        }
        sb.append("Total price: ").append(totalSum);
        return sb.toString();
    }


}
