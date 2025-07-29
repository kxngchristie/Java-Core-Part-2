package practicecodes;

import java.util.HashSet;
import java.util.Set;

public class HashcodeEqualsTest {
    public static void main(String[] args) {

        Student alex1 = new Student(1, "Alex");
        Student alex2 = new Student(1, "Alex");
        Student bob = new Student(2, "Bob");

        HashSet < Student > students = new HashSet < Student > ();

        students.add(alex1);
        students.add(alex2);
        students.add(bob);

        System.out.println("HashSet size = " + students.size());
        System.out.println("HashSet contains Alex = " + students.contains(new Student(1, "Alex")));
    }
}