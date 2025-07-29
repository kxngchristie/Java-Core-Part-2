package practicecodes;

import java.util.PriorityQueue;
import java.util.Iterator;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<String>();
        queue.add("Amit");
        queue.add("Vijay");
        queue.add("Karen");
        queue.add("Jai");
        queue.add("Rahul");

        System.out.println("Head: " + queue.element());
        System.out.println("Head: " +queue.peek());
        System.out.println();
        System.out.println("Iterating the Queue Elements: ");
        Iterator<String> itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        queue.remove();
        queue.poll();

        System.out.println();
        System.out.println("After Removing two Elements: ");
        Iterator<String> itr2 = queue.iterator();;
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }
    }
}