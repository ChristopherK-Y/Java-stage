package day08;

import java.util.Arrays;

//https://leetcode-cn.com/problems/plus-one/
public class PlusOne {
    /**
     *  思路：
     *  倒着从数组开始遍历且+1，如果，这一位加完之后，==10了，那么，就把这一位置0，然后进入下一个循环
     *  如果加完之后，没有产生进位，那么就直接返回现在的数组即可。
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length -1 ; i >= 0; i--) {
            if ((++digits[i]) % 10 == 0) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
