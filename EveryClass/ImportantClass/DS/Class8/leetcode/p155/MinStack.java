package leetcode.p155;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> normal = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int val) {
        normal.push(val);
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        normal.pop();
        min.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
