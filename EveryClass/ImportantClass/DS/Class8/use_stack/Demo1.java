package use_stack;

import java.util.Stack;

public class Demo1 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.size());   // 3
        System.out.println(stack.isEmpty());    // false
        System.out.println(stack.empty());      // false
        System.out.println(stack);

        System.out.println(stack.peek());   // C
        System.out.println(stack.peek());   // C
        System.out.println(stack.pop());    // C
        System.out.println(stack.pop());    // B
    }
}
