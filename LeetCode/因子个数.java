package NowCoder;

import java.util.*;

/**
 * https://www.nowcoder.com/questionTerminal/e8fb8f89f5d147ec92fd8ecfefe89b0d
 */
public class 因子个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            System.out.println(fun(x));
        }
    }

    private static int fun(int x) {
        int count = 0;
        for (int i = 2; i < Math.sqrt(x); i++) {
            boolean can = false;//记录该数可以被当作因子吗？
            while (x % i == 0) {//如果对这个数可以一直整除,那么就一直除
                x /= i;
                can = true;
            }
            if (can) {//加上该数
                count++;
            }
            if (x == 1) {//中途只要x==1了,就除完了,可以提前结束
                break;
            }
        }
        if (x != 1) {//出上面的for循环有两个出①for循环结束②x==1,因此,如果还没有除完,那么最后的这个也是一个因子;
            count++;
        }
        return count;
    }
}
