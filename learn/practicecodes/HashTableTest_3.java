package practicecodes;

import java.util.Hashtable;

public class HashTableTest_3 {
    public static void main(String[] args) {

        int initialCapacity = 20;
        float loadFactor = 0.5f;
        Hashtable<String,Integer> hash = new Hashtable<>(initialCapacity, loadFactor);

        System.out.println("HashTable: " + hash);
    }
}