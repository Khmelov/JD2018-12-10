package by.it.migunko.jd02_01;

import java.util.*;
public class Util {
    static int random(int max){
        return random(0, max);
    }
    static int random(int min, int max){
        return min + (int) (Math.random() * (max-min+1));
    }

    static String goods(int rndCount) {
        StringBuilder sb=new StringBuilder(40);
        HashMap<String, Double> hashMap = new HashMap<>(4);

        hashMap.put("хлеб", 1.0);
        hashMap.put("молоко", 1.0);
        hashMap.put("сметана", 1.5);
        hashMap.put("гречневая крупа", 2.0);
        Set<String> keySet = hashMap.keySet();
        List<String> keys = new ArrayList<>(keySet);
        List<String> goodsList = keys.subList(0, rndCount);

        for (int i = 0; i < rndCount; i++) {
            sb.append(goodsList.get(i)).append(" - ").append(hashMap.get(goodsList.get(i))).append("р. ");
        }
        return sb.toString();
    }

    static  void sleep(int millis){
        try {
            Thread.sleep(millis/Dispatcher.K_SPEED);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
