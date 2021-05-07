package NowCoder;

import java.util.*;

/*
https://www.nowcoder.com/questionTerminal/1221ec77125d4370833fd3ad5ba72395
 */
public class 统计每个月的兔子数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            System.out.println(getTotalCount(x));
        }
    }

    public static int getTotalCount(int monthCount) {
        if (monthCount == 1 || monthCount == 2) {
            return 1;
        }
        //这是第三个月的情况
        int s0 = 1;//距离可以生孩子还有0个月的兔子数
        int s1 = 0;//距离可以生孩子还有1个月的兔子数
        int s2 = 1;//距离可以生孩子还有2个月的兔子数
        for (int i = 0; i < monthCount - 3; i++) {
            s0 += s1;
            s1 = s2;
            s2 = s0;
        }
        return s0 + s1 + s2;
    }
}
