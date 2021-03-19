package NowCoder.动态规划;

//https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec
public class MaxProfit {
    /**
     * 从前往后遍历，如果找到了比现在最小值还小的值，那么就更新当前最小的值
     * 否则就求当前的价格和最小的差值，并且与最大收益进行比较，如果收益更大，更新收益
     * @param prices 股票价格数组
     * @return 最大收益
     */
    public int maxProfit (int[] prices) {
        int min = prices[0];//当前最低的价格
        int maxProfit = 0;//最大收益
        for (int now : prices) {
            if (now < min) {
                min = now;
            } else {
                int profit = now - min;
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }
}
