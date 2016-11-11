package leetcode.BurstBalloons;

import leetcode.common.utils.Utils;

/**
 * Created by ymyue on 7/18/16.
 */
public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] matrix = new int[n][n];
        for (int len = 0; len < n; len++) {
            for (int i = 0; i < n-len; i++) {
                int max = 0;
                int left = i == 0 ? 1 : nums[i-1];
                int right = i+len == n-1 ? 1 : nums[i+len+1];
                for (int j = i; j <= i+len; j++) {
                    int val = left * nums[j] * right;
                    val += j > i ? matrix[i][j-1] : 0;
                    val += j < i+len ? matrix[j+1][i+len] : 0;
                    max = Math.max(max, val);
                }
                matrix[i][i+len] = max;
            }
            Utils.print(matrix);
        }
        return matrix[0][n-1];
    }
}
