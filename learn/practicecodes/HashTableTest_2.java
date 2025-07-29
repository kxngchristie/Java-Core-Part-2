package practicecodes;

import java.util.Hashtable;

public class HashTableTest_2 {
    public static void main(String[] args) {

        int initialCapacity = 20;
        Hashtable<String,Integer> hash = new Hashtable<>(initialCapacity);

        System.out.println("HashTable: " + hash);
    }
}