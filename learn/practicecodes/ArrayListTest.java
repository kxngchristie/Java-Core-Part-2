package practicecodes;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Ravi");
        list.add("ViJay");
        list.add("Ravi");
        list.add("Ajay");

        Iterator itr = list.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
            }
        }
    }