package leetcode.SplitArrayLargestSum;

/**
 * Created by ymyue on 10/8/16.
 */
public class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums.length == 0)
            return 0;
        int n = nums.length;
        int[] sums = new int[n];
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            sums[i] = (i == 0 ? 0 : sums[i-1]) + nums[i];
            dp[0][i] = sums[i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = i; j < n; j++)
                dp[i][j] = binarySearch(dp[i-1], sums, i-1, j-1, j);
        }
        return dp[m-1][n-1];
    }

    private int binarySearch(int[] row, int[] sum, int begin, int end, int n) {
        if (begin == end)
            return Math.max(row[begin], sum[n]-sum[begin]);
        int mid = begin + (end - begin) / 2;
        if (Math.max(row[mid], sum[n] - sum[mid]) < Math.max(row[mid+1], sum[n] - sum[mid+1]))
            end = mid;
        else
            begin = mid + 1;
        return binarySearch(row, sum, begin, end, n);
    }
}
