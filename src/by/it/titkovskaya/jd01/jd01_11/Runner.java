package by.it.titkovskaya.jd01.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        List<String> arList = new ListA<>();
        List<String> brList = new ListB<>();
        System.out.println("\n====Check Addition====");
        myList.add("First"); arList.add("First"); brList.add("First");
        myList.add("Two"); arList.add("Two"); brList.add("Two");
        myList.add("Four"); arList.add("Four"); brList.add("Four");
        System.out.println("myList:"+myList+"\narList:"+arList+"\nbrList:"+brList);
        System.out.println(brList.size());
        myList.add(0,"Start"); arList.add(0,"Start"); brList.add(0,"Start");
        myList.add(2,"Tree"); arList.add(2,"Tree"); brList.add(2,"Tree");
        System.out.println("myList:"+myList+"\narList:"+arList+"\nbrList:"+brList);
        System.out.println(brList.size());
        System.out.println("\n====Check Removal====");
        myList.remove("Start"); arList.remove("Start"); brList.remove("Start");
        myList.remove(3); arList.remove(3); brList.remove(3);
        System.out.println("myList:"+myList+"\narList:"+arList+"\nbrList:"+brList);
        System.out.println("\n====Check Reading====");
        System.out.println("myList(0):"+myList.get(0)+"\narList(0):"+arList.get(0)+"\nbrList(0):"+brList.get(0));

        System.out.println("H a s h S E T");
        HashSet<String> haSet = new HashSet<>();
        SetC<String> mySet = new SetC<>();
        haSet.add("First");
        haSet.add("Two");
        haSet.add("Four");
        mySet.add("First");
        mySet.add("Two");
        mySet.add("Four");
        System.out.println("\n====Check Addition====");
        System.out.println("haSet:"+haSet+"\nmySet:"+mySet);
        System.out.println("\n====Check Removal====");
        haSet.remove("Two");
        mySet.remove("Two");
        System.out.println("haSet:"+haSet+"\nmySet:"+mySet);
        mySet.removeAll(haSet);
        System.out.println("haSet:"+haSet+"\nmySet:"+mySet);
    }
}
