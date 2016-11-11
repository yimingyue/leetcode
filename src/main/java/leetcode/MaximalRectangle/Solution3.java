package leetcode.MaximalRectangle;

import java.util.Arrays;

/**
 * Created by ymyue on 6/11/16.
 * Time complexity: O(mn)
 * Space complexity: O(n)
 * Idea: for each matrix element '1', calculate the area of the max rectangle defined by the following:
 *  the height is the maximum number of successive '1' above this element plus one
 *  the left boundary is the most left boundary satisfy the height
 *  the right boundary if the most right boundary satisfy the height
 *  then we have the following dp equation
 *  height(i,j) = height(i-1,j)+1 if matrix[i][j] == '1'; 0 otherwise
 *  left(i, j) = Math.max{left(i-1, j), current left}
 *  right(i, j) = Math.max{right(i-1, j), current right}
 *  maxArea = (right - left) * height
 */
public class Solution3 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        int maxA = 0;
        Arrays.fill(left, 0);
        Arrays.fill(right, n);
        Arrays.fill(height, 0);

        for (int i = 0; i < m; i++) {
            int curLeft = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j+1;
                }
            }
            int curRight = n;
            for (int j = n-1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }

            for (int j = 0; j < n; j++)
                height[j] = matrix[i][j] == '0' ? 0 : height[j]+1;
            for (int j = 0; j < n; j++) {
                maxA = Math.max(maxA, height[j] * (right[j] - left[j]));
            }
        }
        return maxA;
    }
}
