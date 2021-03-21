package leetcode.jzoffer31;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    private List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int e : array) {
            list.add(e);
        }
        return list;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        List<Integer> pushedList = arrayToList(pushed);
        List<Integer> popedList = arrayToList(popped);

        Stack<Integer> stack = new Stack<>();

        for (int e : popedList) {
            if (!stack.isEmpty() && stack.peek() == e) {
                stack.pop();
                continue;
            }

            while (true) {
                if (pushedList.isEmpty()) {
                    return false;
                }
                int f = pushedList.remove(0);
                if (f != e) {
                    stack.push(f);
                } else {
                    break;
                }
            }
        }

        return stack.isEmpty();
    }
}
