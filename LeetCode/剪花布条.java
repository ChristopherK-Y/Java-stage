package NowCoder;

import java.util.*;

/**
 * https://www.nowcoder.com/questionTerminal/1046cd038f7a4b04b2b77b415973de1c
 */
public class 剪花布条 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] in = sc.nextLine().split(" ");
            String b = in[0];
            String s = in[1];
            System.out.println(fun(b, s));
        }
    }

    private static int fun(String b, String s) {
        int count = 0;
        while (b.contains(s)) {
            count++;
            b = b.replaceFirst(s, "");
        }
        return count;
    }
}
