package NowCoder;

import java.util.Stack;

//https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106
public class IsPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        int x = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < popA.length; i++) {
            if (!(stack.isEmpty()) && stack.peek() == popA[i]) {//如果栈不是空的，且当前栈顶的元素就是需要的元素，那么直接出栈
                stack.pop();
            } else {
                boolean flag = true;//用来标志是否找到想要找到的元素，或者push队列是否为空
                for (; x < pushA.length; x++) {
                    if (pushA[x] != popA[i]) {//如果不是想要找的元素，直接入栈
                        stack.push(pushA[x]);
                    } else {
                        flag = false;//如果是了，改标志位
                        x++;//push指针后移
                        break;
                    }
                }
                if (flag) {
                    return false;
                }
            }
        }
        return true;
    }
}
