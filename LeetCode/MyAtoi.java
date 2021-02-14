package day10;

//https://leetcode-cn.com/problems/string-to-integer-atoi/
public class MyAtoi {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        char head = s.charAt(0);
        if (head != '-' && head != '+' && !Character.isDigit(head)) {
            //如果开头既不是符号位也不是数字，那么就转换不了数字
            return 0;
        }
        StringBuilder number = new StringBuilder();
        number.append(head);
        try {
            for (int i = 1; i < s.length(); i++) {
                char oneCharacter = s.charAt(i);
                if (Character.isDigit(oneCharacter)) {
                    number.append(oneCharacter);
                } else {
                    break;
                }
            }
            if (number.length() == 1 && (number.charAt(0) == '-' || number.charAt(0) == '+')) {
                //如果现在的字符串长度仅仅只有长度1，且只是一个符号位，那么直接返回0
                return 0;
            }
            return Integer.parseInt(new String(number));
        } catch (NumberFormatException e) {
            if (head == '-') {//发生越界异常了（格式化异常），那么返回最大值
                return -2147483648;
            }
            return 2147483647;
        }
    }
}
