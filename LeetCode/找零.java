package NowCoder;

import java.util.Scanner;

//https://www.nowcoder.com/practice/944e5ca0ea88471fbfa73061ebe95728?tpId=137&tqId=33900&rp=1&ru=%2Fta%2Fexam-bytedance&qru=%2Fta%2Fexam-bytedance%2Fquestion-ranking&tab=answerKey
public class 找零 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int surplus = 1024 - in.nextInt();
        int count = 0;
        count += surplus / 64;
        surplus -= 64 * (surplus / 64);
        if (surplus == 0) {
            System.out.println(count);
            return;
        }
        count += surplus / 16;
        surplus -= 16 * (surplus / 16);
        if (surplus == 0) {
            System.out.println(count);
            return;
        }
        count += surplus / 4;
        surplus -= 4 * (surplus / 4);
        if (surplus == 0) {
            System.out.println(count);
            return;
        }
        System.out.println(count + surplus);
    }
}
