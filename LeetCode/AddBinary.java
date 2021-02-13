package day09;

import java.util.Arrays;

//https://leetcode-cn.com/problems/add-binary/
public class AddBinary {
    /**
     *
     * @param a 加数1
     * @param b 加数2
     * @return 加数的和
     */
    public String addBinary(String a, String b) {
        int carry = 0;//进位
        int sum = 0;//本次加的和（a的一位、b的一位、进位）
        int endA = a.length() - 1;
        int endB = b.length() - 1;
        StringBuilder ret = new StringBuilder();
        while (endA >= 0 && endB >= 0) {
            sum = carry;
            sum += a.charAt(endA--) - '0';
            sum += b.charAt(endB--) - '0';
            carry = sum / 2;
            ret.append(sum % 2);
        }
        while (endA >= 0) {
            sum = carry;
            sum += a.charAt(endA--) - '0';
            carry = sum / 2;
            ret.append(sum % 2);
        }
        while (endB >= 0) {
            sum = carry;
            sum += b.charAt(endB--) - '0';
            carry = sum / 2;
            ret.append(sum % 2);
        }
        if (carry != 0) {
            ret.append(carry);
        }
        return new String(ret.reverse());
    }
}
//方法1：溢出了
//        int numberA = Integer.parseInt(a, 2);
//        int numberB = Integer.parseInt(b, 2);
//        return Integer.toBinaryString(numberA + numberB);
