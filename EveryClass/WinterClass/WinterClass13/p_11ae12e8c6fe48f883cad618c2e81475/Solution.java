package p_11ae12e8c6fe48f883cad618c2e81475;

import java.util.*;

public class Solution {
    public String solve (String s, String t) {
        if (s.equals("0")) {
            return t;
        }
        // 1. 把字符串变成字符数组
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // 2. 把字符数组变成整型数组
        int[] sIntArray = toIntArray(sArray);
        int[] tIntArray = toIntArray(tArray);

        // 3. 逆置整型数组
        int[] a = reverse(sIntArray);
        int[] b = reverse(tIntArray);

        int minLen = Math.min(a.length, b.length);
        int maxLen = Math.max(a.length, b.length);
        int[] rArray = new int[maxLen + 1];
        int carry = 0;  // 进位：一开始没有
        // 4. 先处理公共的部分
        int i;
        for (i = 0; i < minLen; i++) {
            int r = a[i] + b[i] + carry;
            rArray[i] = r % 10;
            carry = r / 10;
        }
        // 5. 处理非公共部分
        // 5.1 找到最长的数组
        int[] maxArr = a;
        if (b.length > a.length) {
            maxArr = b;
        }

        for (; i < maxLen; i++) {
            int r = maxArr[i] + carry;
            rArray[i] = r % 10;
            carry = r / 10;
        }

        // 6. 处理最后的进位
        rArray[maxLen] = carry;

        // 7. 把整型数组逆置回来
        int[] ansInt = reverse(rArray);

        // 8. 把 int[] -> char[]，前置的 0 不要
        char[] ansChar = toCharArray(ansInt);

        return new String(ansChar);
    }

    // 即使有前置 0，也只会有一位
    private char[] toCharArray(int[] ansInt) {
        int n = ansInt.length;
        for (int i = 0; i < ansInt.length; i++)  {
            if (ansInt[i] != 0) {
                break;
            }

            n--;
        }

        char[] ans = new char[n];
        int j = 0;  // j 给 ans 用的
        int i = 0;
        // 先把前置 0 跳过
        for (; i < ansInt.length; i++) {
            if (ansInt[i] != 0) {
                break;
            }
        }
        // 不需要再考虑 0 的问题了
        for (; i < ansInt.length; i++) {
            ans[j++] = (char)(ansInt[i] + '0');
        }

        return ans;
    }

    // array 没有改，逆置后的结果放在新数组中
    private int[] reverse(int[] array) {
        int n = array.length;
        int[] result = Arrays.copyOf(array, n);

        for (int i = 0; i < n / 2; i++) {
            // [i] <-> [len - 1 - i]
            // i == 0: [0] <-> [len - 1]
            // i == 1: [1] <-> [len - 2]
            // i == 2: [2] <-> [len - 3]
            // ...
            result[i] = array[n - 1 - i];
            result[n - 1 - i] = array[i];
        }

        return result;
    }

    private int[] toIntArray(char[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            int integer = ch - '0';
            result[i] = integer;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "0";
        String t = "0";
        // [0, 1, 1]

//        String s = "1039";
//        String t = "28";
//        // [7, 6, 0, 1]

        Solution solution = new Solution();
        System.out.println(solution.solve(s, t));
    }
}
