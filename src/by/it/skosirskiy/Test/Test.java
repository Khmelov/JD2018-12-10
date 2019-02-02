package by.it.skosirskiy.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static HashMap<Buyer, HashMap<String, Integer>> cheсkHashMap=new HashMap<>();

    public static void main(String[] args) {
        HashMap<String, Integer> bufHashMap= new HashMap<>();
        Buyer buyer= new Buyer(26);
        bufHashMap.put("milk", 100);
        bufHashMap.put("butter", 300);
        bufHashMap.put("bread", 110);
        bufHashMap.put("apple", 50);
        bufHashMap.put("juice", 130);
        bufHashMap.put("pork", 500);
        bufHashMap.put("chicken", 350);
        for (Map.Entry entry : bufHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
        cheсkHashMap.put(buyer,bufHashMap);
        System.out.println(cheсkHashMap.put(buyer,bufHashMap));
    }
}

