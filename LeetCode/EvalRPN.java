package day12;

//https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length / 2 + 1];
        int top = 0;
        for (String nowString : tokens) {
            //从左往右扫描，如果是数字，那么存进栈中，否则就从栈中读出两个操作数，并进行计算和写入
            switch (nowString) {
                case "+":
                    stack[top - 2] += stack[top - 1];
                    top--;
                    break;
                case "-":
                    stack[top - 2] -= stack[top - 1];
                    top--;
                    break;
                case "*":
                    stack[top - 2] *= stack[top - 1];
                    top--;
                    break;
                case "/":
                    stack[top - 2] /= stack[top - 1];
                    top--;
                    break;
                default:
                    stack[top++] = Integer.parseInt(nowString);
                    break;
            }
        }
        return stack[0];//最后栈中就剩一个元素了，直接返回就是结果了
    }

    //方法2：错误的！！！！只能计算各位的数字的
    public int evalRPN2(String[] tokens) {
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            char oneChar = tokens[i].charAt(0);
            int length = numbers.length();
            int number1, number2;
            if (Character.isDigit(oneChar)) {
                numbers.append(oneChar);
            } else {
                switch (oneChar) {
                    case '+':
                        number1 = Integer.parseInt(String.valueOf(numbers.charAt(length - 1)));
                        number2 = Integer.parseInt(String.valueOf(numbers.charAt(length - 2)));
                        numbers.replace(length - 2, length, Integer.toString(number1 + number2));
                        break;
                    case '-':
                        number1 = Integer.parseInt(String.valueOf(numbers.charAt(length - 1)));
                        number2 = Integer.parseInt(String.valueOf(numbers.charAt(length - 2)));
                        numbers.replace(length - 2, length, Integer.toString(number1 - number2));
                        break;
                    case '*':
                        number1 = Integer.parseInt(String.valueOf(numbers.charAt(length - 1)));
                        number2 = Integer.parseInt(String.valueOf(numbers.charAt(length - 2)));
                        numbers.replace(length - 2, length, Integer.toString(number1 * number2));
                        break;
                    case '/':
                        number1 = Integer.parseInt(String.valueOf(numbers.charAt(length - 1)));
                        number2 = Integer.parseInt(String.valueOf(numbers.charAt(length - 2)));
                        numbers.replace(length - 2, length, Integer.toString(number1 / number2));
                        break;
                }
            }
        }
        return Integer.parseInt(new String(numbers));
    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("result = " + evalRPN.evalRPN(tokens));
    }
}
