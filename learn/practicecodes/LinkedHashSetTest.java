package practicecodes;

import java.util.LinkedHashSet;
import java.util.Iterator;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<String> lhset = new LinkedHashSet<String>();
        lhset.add("Ravi");
        lhset.add("Vijay");
        lhset.add("Ravi");
        lhset.add("Ajay");

        Iterator<String> itr = lhset.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}