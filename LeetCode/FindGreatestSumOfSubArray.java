package NowCoder.动态规划;

//https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484
public class FindGreatestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[2];
        dp[0] = array[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < array.length; i++){
            dp[1] = Math.max(dp[0]+array[i], array[i]);
            max = Math.max(max,dp[1]);
            dp[0] = dp[1];
        }
        return max;
    }
}
