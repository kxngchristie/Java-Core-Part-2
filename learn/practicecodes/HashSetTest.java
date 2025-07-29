package practicecodes;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> hset = new HashSet<String>();
        hset.add("Ravi");
        hset.add("Vijay");
        hset.add("Ravi");
        hset.add("Ajay");

        Iterator<String> itr = hset.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}