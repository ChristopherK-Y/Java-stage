package use_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Demo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("A");
        queue.add("B");
        queue.add("C");
        System.out.println(queue);
        System.out.println(queue.remove()); // A
        System.out.println(queue.element());    // B
        System.out.println(queue.remove()); // B
    }
}
