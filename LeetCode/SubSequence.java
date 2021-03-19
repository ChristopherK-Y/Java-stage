package NowCoder.动态规划;

public class SubSequence {
    /**
     * 从前往后遍历整个数组：
     * 那么遍历到第i个元素的时候，要获得最优解就应该为 dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i]);
     * （因为，有条件，不能取相邻的两个数）
     * 因此，我们这里，就使用2个数，来代表dp[i - 2] 和 dp[i - 1]
     *
     * @param n int整型 数组的长度
     * @param array int整型一维数组 长度为n的数组
     * @return long长整型
     */
    public long subSequence (int n, int[] array) {
        long dp_2 = 0;
        long  dp_1 = 0;
        for(int number : array){
            long dpNow = Math.max(dp_1, dp_2 + number);
            dp_2 = dp_1;
            dp_1 = dpNow;
        }
        return dp_1;
    }
}
