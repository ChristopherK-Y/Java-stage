package day03;

//https://leetcode-cn.com/problems/palindrome-number/
public class IsPalindrome {
    //方法1：转为字符串进行逆置，然后equals对比
    public boolean isPalindrome1(int x) {
        String xString = Integer.toString(x);
        StringBuilder reverseXString = new StringBuilder();
        for (int i = xString.length() - 1; i >= 0; i--) {
            reverseXString.append(xString.charAt(i));
        }
        return xString.equals(new String(reverseXString));
    }

    //方法2：逆置转为数，直接比大小
    public boolean isPalindrome2(int x) {
        if (x < 0) {//如果小于0，那么一定不是回文数
            return false;
        }
        int ans = 0;
        int temp = x;
        while (x > 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans == temp;
    }
}
