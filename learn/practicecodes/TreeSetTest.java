package practicecodes;

import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> tset = new TreeSet<String>();
        tset.add("Ravi");
        tset.add("Vijay");
        tset.add("Ravi");
        tset.add("Ajay");

        Iterator<String> itr = tset.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}