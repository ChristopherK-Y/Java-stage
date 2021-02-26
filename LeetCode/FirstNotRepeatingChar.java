package NowCoder;

import java.util.HashMap;
import java.util.Map;

//https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        int[] everyNumbers = new int[58];
        for (int i = 0; i < str.length(); i++) {
            everyNumbers[(int) str.charAt(i) - 65]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (everyNumbers[(int) str.charAt(i) - 65] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingChar().firstNotRepeatingChar("googgle"));
    }
}
