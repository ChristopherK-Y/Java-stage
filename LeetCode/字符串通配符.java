package NowCoder;

import java.util.*;

/**
 * https://www.nowcoder.com/questionTerminal/43072d50a6eb44d2a6c816a283b02036
 */
public class 字符串通配符 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            System.out.println(helper(s1, s2, 0, 0));
        }
    }

    private static boolean helper(String s1, String s2, int p1, int p2) {
        //base case
        if (p1 == s1.length() && p2 == s2.length()) {
            return true;
        } else if (p1 == s1.length() || p2 == s2.length()) {
            return false;
        }
        //遇到'*'情况:①第一个先不忙，第二个往后走②第一个第二个都往后走一个③第一个往后走，第二个不动（*可能有0个的情况）
        if (s1.charAt(p1) == '*') {
            return helper(s1, s2, p1, p2 + 1) || helper(s1, s2, p1 + 1, p2 + 1) || helper(s1, s2, p1 + 1, p2);
            //遇到'?'跟两个一样操作一样，直接指针都往后移一个继续比较
        } else if (s1.charAt(p1) == '?' || s1.charAt(p1) == s2.charAt(p2)) {
            return helper(s1, s2, p1 + 1, p2 + 1);
        } else {
            return false;
        }
    }
}
