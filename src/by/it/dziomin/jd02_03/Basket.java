package by.it.dziomin.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Basket {

    private Map<Good, Integer> goods = new HashMap<>();

    public Map<Good, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<Good, Integer> goods) {
        this.goods = goods;
    }

    void addGood(Good good) {
        int n = 1;
        if (goods.containsKey(good)) {
            n = n + goods.get(good);
        }
        goods.put(good, n);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        goods.forEach((good, count) -> sb.append(good.getName()).append(" ")
                .append(good.getPrice()).append(" ").append(count).append("шт, "));
        sb.setLength(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }

    public void clear(){
        goods.clear();
    }
}
