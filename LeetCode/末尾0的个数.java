package NowCoder;

import java.util.*;

public class 末尾0的个数 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/aa03dff18376454c9d2e359163bf44b8
     *
     * 阶乘末尾0的数量就是能拆出来的5的数量。但是，从 1 遍历到 n 每个数看一下它能除多少次 5 是不行的。因为 n 的数据范围是1e18。遍历1e18个数复杂度太大了。
     * 那我们来考虑一下，5的倍数可以至少产生1个5，25的倍数可以产生至少2个5，125的倍数可以产生至少3个5...
     * 这样的话1~n中有n/5个5的倍数，n/25个25的倍数，n/125个125的倍数...
     *
     * 所以答案就是 n/5+n/25+n/125.. 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        System.out.println(fun(in));
    }

    private static long fun(int n) {
        long count = 0;
        long i = 5;
        while(n != 0){
            count += n/5;
            n /= 5;
        }
        return count;
    }
}
