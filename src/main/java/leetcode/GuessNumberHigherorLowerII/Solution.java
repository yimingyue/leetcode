package leetcode.GuessNumberHigherorLowerII;

/**
 * Created by ymyue on 7/20/16.
 * Last modified by ymyue on 9/28/2016
 * Time complexity: O(n^3)
 * Space complexity: O(n^2)
 */
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] matrix = new int[n+1][n+1];
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i+len-1 <= n; i++) {
                if (len == 1)
                    matrix[i][i] = 0;
                else {
                    matrix[i][i+len-1] = Math.min(i + matrix[i+1][i+len-1], i+len-1 + matrix[i][i+len-2]);
                    for (int j = i+1; j < i+len-1; j++) {
                        matrix[i][i+len-1] = Math.min(matrix[i][i+len-1], j + Math.max(matrix[i][j-1], matrix[j+1][i+len-1]));
                    }
                }
            }
        }
        return matrix[1][n];
    }
}
