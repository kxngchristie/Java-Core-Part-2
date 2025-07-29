package practicecodes;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest_1 {
    public static void main(String [] args) {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map.put(1, "Mango");
        map.put(2, "Apple");
        map.put(3, "Banana");
        map.put(1, "Grapes");
        System.out.println("Iterating HashMAap....");

        for(Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}