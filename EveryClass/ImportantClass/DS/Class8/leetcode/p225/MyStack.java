package leetcode.p225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> queue;
        if (!queue1.isEmpty()) {
            queue = queue1;
        } else if (!queue2.isEmpty()) {
            queue = queue2;
        } else {
            queue = queue1;
        }

        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> queue;
        Queue<Integer> toQueue;
        if (!queue1.isEmpty()) {
            queue = queue1;
            toQueue = queue2;
        } else {
            queue = queue2;
            toQueue = queue1;
        }

        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            int e = queue.remove();
            toQueue.add(e);
        }

        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        Queue<Integer> queue;
        Queue<Integer> toQueue;
        if (!queue1.isEmpty()) {
            queue = queue1;
            toQueue = queue2;
        } else {
            queue = queue2;
            toQueue = queue1;
        }

        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            int e = queue.remove();
            toQueue.add(e);
        }

        int f = queue.remove();
        toQueue.add(f);
        return f;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
