package NowCoder;

public class 年终奖 {
    public int getMost(int[][] board) {
        int[][] dp = new int[7][7];
        for(int i = 0; i < 7; i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for(int i = 1; i < 7; i++){
            for(int j = 1; j < 7; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + board[i-1][j-1];
            }
        }
        return dp[6][6];
    }
}
