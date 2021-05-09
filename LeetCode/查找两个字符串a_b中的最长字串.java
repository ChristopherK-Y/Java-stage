package NowCoder;

import java.util.*;

/*
https://www.nowcoder.com/questionTerminal/181a1a71c7574266ad07f9739f791506
 */

public class 查找两个字符串a_b中的最长字串 {

    /**
     * 暴力法，n^2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String max = s1.length() >= s2.length() ? s1 : s2;
            String min = max == s1 ? s2 : s1;
            int maxLength = 0;
            String ans = null;
            for (int i = 0; i < min.length(); i++) {
                for (int j = i + 1; j <= min.length(); j++) {//substring可以走到min.length的位置
                    if (j - i > maxLength && max.contains(min.substring(i, j))) {
                        ans = min.substring(i, j);
                        maxLength = j - i;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
