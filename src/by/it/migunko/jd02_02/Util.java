package by.it.migunko.jd02_02;

import java.util.*;

public class Util {
    static int getRandom(int min, int max){
        return min+(int)(Math.random()*(max-min+1));
    }

    static int getRandom(int max){
        return getRandom(0,max);
    }
    static String goods(int rndCount) {
        StringBuilder sb=new StringBuilder(40);

        HashMap<String, Double> hashMap = new HashMap<>(4);

        hashMap.put("хлеб", 1.0);
        hashMap.put("молоко", 2.0);
        hashMap.put("сметана", 3.0);
        hashMap.put("крупа гречневая", 1.0);
        Set<String> keySet = hashMap.keySet();
        List<String> listOfKeys = new ArrayList<>(keySet);
        Collections.shuffle(listOfKeys);
        List<String> goodsList = listOfKeys.subList(0, rndCount);

        for (int i = 0; i < rndCount; i++) {
            sb.append(goodsList.get(i)).append(" - ").append(hashMap.get(goodsList.get(i))).append("р. ");
        }
        return sb.toString();
    }
    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
