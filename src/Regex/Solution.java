package Regex;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/3/14
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean [][] dp = new boolean[m+1][n+1];
        int i = 0;
        while (i < m+1) {
            int j = 0;
            while (j < n+1) {
                if (i == 0 && j == 0)
                    dp[i][j] =  true;

                    // s = "", p = "m*n*"
                else if (i == 0) {
                    if (j == 1)
                        dp[i][j] = false;
                    else if (p.charAt(j-1) == '*')
                        dp[i][j] = dp[i][j-2];
                    else
                        dp[i][j] = false;
                } else {
                    if (j == 0)
                        dp[i][j] = false;
                    else if (j == 1) {
                        if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1))
                            dp[i][j] = dp[i-1][j-1];
                        else
                            dp[i][j] = false;
                    }
                    else if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else if (p.charAt(j-1) == '*') {
                        dp[i][j] = (dp[i][j-1] | dp[i][j-2]);
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
                j = j+1;
            }
            for (int k = 0; k <= n; k++)
                System.out.print(dp[i][k] + " ");
            System.out.println();
            i = i+1;
        }
        return dp[m][n];
    }
}
