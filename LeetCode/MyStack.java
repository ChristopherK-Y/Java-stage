package NowCoder;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode-cn.com/problems/implement-stack-using-queues/submissions/
public class MyStack {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        //
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(x);
        } else if (queue1.isEmpty()) {
            queue2.add(x);
        } else {
            queue1.add(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queue1.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        } else {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (queue1.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue1.add(queue2.remove());
            }
            int peek = queue2.remove();
            queue1.add(peek);
            return peek;
        } else {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) {
                queue2.add(queue1.remove());
            }
            int peek = queue1.remove();
            queue2.add(peek);
            return peek;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty () {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
