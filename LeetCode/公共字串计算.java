package NowCoder;

import java.util.*;
/*
https://ac.nowcoder.com/questionTerminal/98dc82c094e043ccb7e0570e5342dd1b
就是最复杂的n^2
 */
public class 公共字串计算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(getCommonStrLength(s1, s2));
        }
    }

    private static int getCommonStrLength(String s1, String s2) {
        int maxLength = 0;
        String max = s1.length() > s2.length() ? s1 : s2;
        String min = max == s1 ? s2 : s1;
        for (int i = 0; i < min.length(); i++) {
            for (int j = i + 1; j <= min.length(); j++) {
                if (j - i > maxLength && max.contains(min.substring(i, j))) {
                    maxLength = j - i;
                }
            }
        }
        return maxLength;
    }
}
