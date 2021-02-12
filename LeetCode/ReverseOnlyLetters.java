package day06;

//https://leetcode-cn.com/problems/reverse-only-letters/
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] charArray = S.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            while (start < end && !Character.isLetter(charArray[start])) {//从左往右找字母
                start++;
            }
            while (start < end && !Character.isLetter(charArray[end])) {//从右往左找字母
                end--;
            }
            if (start < end) {
                exchange(charArray, start++, end--);//找到以后就交换，更新指针
            }
        }
        return new String(charArray);
    }

    private void exchange(char[] charArray, int start, int end) {
        charArray[start] ^= charArray[end];
        charArray[end] ^= charArray[start];
        charArray[start] ^= charArray[end];
    }

    public static void main(String[] args) {
        ReverseOnlyLetters test = new ReverseOnlyLetters();
        String s = "ab-cd";
        System.out.println(test.reverseOnlyLetters(s));
    }
}
