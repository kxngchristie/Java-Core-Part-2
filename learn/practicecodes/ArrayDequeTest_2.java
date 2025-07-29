package practicecodes;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeTest_2 {
    public static void main(String[] args) {
        Deque<String> dq = new ArrayDeque<String>();
        dq.offer("arvind");
        dq.offer("vimal");
        dq.add("mukul");
        dq.offerFirst("jai");
        System.out.println("After offerFirst() Traversal....");
        for (String s: dq) {
            System.out.println(s);
        }

        dq.pollLast();
        System.out.println();
        System.out.println("After pollLast() Traversal....");
        for (String s: dq) {
            System.out.println(s);
        }
    }
}