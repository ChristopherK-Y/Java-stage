package use_stack;

import java.util.Deque;
import java.util.LinkedList;

public class Demo2 {
    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack);
        System.out.println(stack.isEmpty());    // false
        System.out.println(stack.size());   // 3
        System.out.println(stack.peek());   // C
        System.out.println(stack.peek());   // C
        System.out.println(stack.pop());    // C
        System.out.println(stack.pop());    // B
    }
}
