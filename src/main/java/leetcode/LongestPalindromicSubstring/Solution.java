package leetcode.LongestPalindromicSubstring;

/**
 * Created by ymyue on 5/17/15.
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1)
            return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            dp[i][i] = true;
            dp[i][i-1] = true;
        }
        int left = 0;
        int right = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i+j < n; i++) {
                dp[i][i+j] = (s.charAt(i) == s.charAt(i+j)) && dp[i+1][i+j-1];
                if (dp[i][i+j]) {
                    left = i;
                    right = i+j+1;
                }
            }
        }
        return s.substring(left, right);
    }
}
