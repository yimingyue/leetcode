package leetcode.DistinctSubsequences;

/**
 * Created by ymyue on 10/10/15.
 */

public class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length())
            return 0;
        if (s.length() == t.length())
            return s.equals(t) ? 1 : 0;
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i <= s.length(); i++)
            dp[i][0] = 1;
        for (int j = 1; j <= t.length(); j++) {
            for (int i = 0; i <= s.length(); i++) {
                if (i < j) {
                    dp[i][j] = 0;
                } else {
                    if (s.charAt(i-1) == t.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}