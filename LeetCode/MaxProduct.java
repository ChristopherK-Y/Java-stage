package NowCoder.动态规划;

import java.util.Scanner;

//https://www.nowcoder.com/questionTerminal/f46135ecf26a45b3b964239ebc745aac

/**
 * arr【i】表示到i位置时得到的最大累乘积
 *
 * 到i位置时，只有以下三种可能:
 *
 * 1.可能是max*arr[i]。max既然表示以arr[i-1]结尾的最大累乘积，那么当然有可能;以a[i]结尾的最大累乘积是max*arr[i]。例如，[3,4,5]在 算到5的时候。
 *
 * 2.可能是min*arr[i]。min既然表示以af[i-1]结尾的最小累乘积，当然有可能min是
 *
 *  负数，而如果ar[i也是负数，两个负数相乘的结果也可能很大。例如，[-2,3.-4]在算到-4的时候。
 *
 *  3. 可能仅是a[i]的值。以a[i]结尾的最大累乘积并不一定非要包含ar[i]之前的数。
 *
 *  例如，[0.1,0.1,100]在 算到100的时候。
 *
 *  这三种可能的值中最大的那个就作为以i位置结尾的最大累乘积，最小的作为最小累乘积，继续计算。
 */
public class MaxProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        double max = sc.nextDouble();
        double min = max;
        double res = max;
        double maxEnd = 0;
        double minEnd = 0;
        for (int i = 0; i < size; i++) {
            double now = sc.nextDouble();
            maxEnd = max * now;
            minEnd = min * now;
            max = Math.max(Math.max(maxEnd, minEnd), now);
            min = Math.min(Math.min(maxEnd, minEnd), now);
            res = Math.max(res, max);
        }
        System.out.println(res);
    }
}
