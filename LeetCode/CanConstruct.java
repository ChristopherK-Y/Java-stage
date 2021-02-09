package day03;

import java.util.Arrays;

//https://leetcode-cn.com/problems/ransom-note/
public class CanConstruct {
    //统计两个字符串中各字母的频率，然后进行对比即可
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countOfRansomNote = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] countOfMagazine = Arrays.copyOf(countOfRansomNote, 26);
        for (int i = 0; i < ransomNote.length(); i++) {
            countOfRansomNote[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            countOfMagazine[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (countOfRansomNote[i] > countOfMagazine[i]) {
                return false;
            }
        }
        return true;
    }
}
