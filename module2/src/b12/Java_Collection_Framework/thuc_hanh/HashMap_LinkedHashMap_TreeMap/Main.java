package b12.Java_Collection_Framework.thuc_hanh.HashMap_LinkedHashMap_TreeMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Khue", 23);
        hashMap.put("Alan", 26);
        hashMap.put("Anny", 24);
        hashMap.put("Vinh Khue", 35);
        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Alan", 26);
        treeMap.put("Zinh Khue", 35);
        treeMap.put("Anny", 24);
        treeMap.put("Khue", 23);
        System.out.println("Display entries in treeMap");
        System.out.println(treeMap);
        Map<String,Integer> linkedHashMap=new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));
    }
}
