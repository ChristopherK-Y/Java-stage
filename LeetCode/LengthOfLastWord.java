package day04;

//https://leetcode-cn.com/problems/length-of-last-word/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        if(array.length!=0) {
            return array[array.length - 1].length();
        }else{
            return 0;
        }
    }
}
