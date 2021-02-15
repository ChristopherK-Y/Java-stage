package day11;

//https://leetcode-cn.com/problems/valid-palindrome/
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder theString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {//先把所有的字母和数字挑出来，然后进行首位对比看
            char theCharacter = s.charAt(i);
            if (Character.isLetter(theCharacter) || Character.isDigit(theCharacter)) {
                theString.append(theCharacter);
            }
        }
        s = new String(theString).toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
