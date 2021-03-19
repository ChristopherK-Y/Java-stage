package NowCoder;

import java.util.ArrayDeque;

//https://www.nowcoder.com/practice/37548e94a270412c8b9fb85643c8ccc2
public class IsValid {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        //方法1：
//        ArrayDeque<Character> stack = new ArrayDeque<>();
//        for (int i = 0; i < s.length(); i++) {
//            char oneElement = s.charAt(i);
//            switch (oneElement) {
//                case '(':
//                case '{':
//                case '[':
//                    stack.push(oneElement);
//                    break;
//                case ')':
//                    if (stack.size() == 0) {
//                        return false;
//                    }
//                    if (stack.pop() != '(') {
//                        return false;
//                    }
//                    break;
//                case '}':
//                    if (stack.size() == 0) {
//                        return false;
//                    }
//                    if (stack.pop() != '{') {
//                        return false;
//                    }
//                    break;
//                case ']':
//                    if (stack.size() == 0) {
//                        return false;
//                    }
//                    if (stack.pop() != '[') {
//                        return false;
//                    }
//                    break;
//            }
//        }
//        return stack.size() == 0;
        //方法2：
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char oneElement = s.charAt(i);
            if (oneElement == '(') {
                stack.push(')');
            } else if (oneElement == '{') {
                stack.push('}');
            } else if (oneElement == '[') {
                stack.push(']');
            } else {
                if (stack.size() == 0 || stack.pop() != oneElement) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("["));
    }
}
