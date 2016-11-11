package google.CountOfEqualDivide;

/**
 * Created by ymyue on 10/4/16.
 * http://www.1point3acres.com/bbs/thread-202812-1-1.html
 * Round 1, Question 2
 */
public class Solution {
    public int countOfEqualDivide(int n) {
        int sum = (n + 1) * n / 2;
        if ((sum & 1) == 1)
            return 0;

        int target = sum / 2;
        int[][] dp = new int[target+1][n+1];
        dp[0][0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1];
                if (i >= j)
                    dp[i][j] += dp[i-j][j-1];
            }
        }
        return dp[target][n];
    }
}
