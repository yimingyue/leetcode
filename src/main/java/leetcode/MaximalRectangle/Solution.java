package leetcode.MaximalRectangle;

import java.util.Stack;

/**
 * Created by ymyue on 7/19/15.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] vals = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    sum = 0;
                } else {
                    sum++;
                }
                vals[i][j] = sum;
            }
        }
        for (int j = 0; j < n; j++) {
            Stack<Integer> stack = new Stack<Integer> ();
            for (int i = 0; i < m+1; i++) {
                while (!stack.isEmpty()) {
                    int k = stack.peek();
                    if (i < m && vals[i][j] > vals[k][j]) {
                        break;
                    } else {
                        k = stack.pop();
                        int r = -1;
                        if (!stack.isEmpty())
                            r = stack.peek();
                        int area = (i - r - 1) * vals[k][j];
                        maxArea = Math.max(area, maxArea);
                    }
                }
                stack.push(i);
            }
        }
        return maxArea;
    }
}
