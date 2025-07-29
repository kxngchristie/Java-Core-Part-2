package practicecodes;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeTest_1 {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("Ravi");
        deque.add("ViJay");
        deque.add("Ajay");

        for (String s: deque) {
            System.out.println(s);
        }
    }
}