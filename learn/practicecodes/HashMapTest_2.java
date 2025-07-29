package practicecodes;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest_2 {
    public static void main (String [] args) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        System.out.println("Initial List of Elements: " + hm);
        hm.put(100, "Amit");
        hm.put(101, "Vijay");
        hm.put(102, "Rahul");

        System.out.println();
        System.out.println("After Invoking put() Method: ");

        for (Map.Entry m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        hm.putIfAbsent(103, "Gaurav");
        System.out.println();
        System.out.println("After Invoking putIfAbsent() Method:");

        for (Map.Entry m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(104, "ravi");
        map.putAll(hm);

        System.out.println();
        System.out.println("After Invoking putAll() Method:");

        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}