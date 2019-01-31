package by.it.dziomin.jd02_01;

import java.util.*;

import static by.it.dziomin.jd02_01.Constants.MAX_COUNT_GOODS_IN_BASKET;
import static by.it.dziomin.jd02_01.Constants.MIN_COUNT_GOODS_IN_BASKET;

class Util {

    static int getRandom(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    static int getRandom(int max) {
        return getRandom(0, max);
    }

    static void sleep(long timeout) {
        try {
            Thread.sleep(timeout / Constants.SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static List<String> generateChoseGoods(Set<String> goodsNames) {
        List<String> names = new ArrayList<>(goodsNames);

        int countGoods = Util.getRandom(MIN_COUNT_GOODS_IN_BASKET, MAX_COUNT_GOODS_IN_BASKET);

        List<String> choseGoodNames = new ArrayList<>();
        for (int i = 0; i < countGoods; i++) {
            int idGood = Util.getRandom(0, goodsNames.size() - 1);
            choseGoodNames.add(names.get(idGood));
        }
        return choseGoodNames;
    }
}
