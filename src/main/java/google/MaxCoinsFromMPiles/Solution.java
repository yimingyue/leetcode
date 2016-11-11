package google.MaxCoinsFromMPiles;

/**
 * Created by ymyue on 10/11/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=189741&extra=&highlight=google&page=1
 * Question 1
 */
public class Solution {
    public int maxCoins(int[][] coins, int n) {
        int[][] dp = new int[coins.length][n+1];
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                int sum = 0;
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], sum + dp[i-1][j-k]);
                    sum += k < coins[i].length ? coins[i][k] : 0;
                }
            }
        }
        return dp[coins.length-1][n-1];
    }
}
