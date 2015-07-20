package leetcode.MaximalRectangle;

import java.util.Stack;

/**
 * Created by ymyue on 7/19/15.
 */

/*
    Solution from: http://www.programcreek.com/2014/05/leetcode-maximal-rectangle-java/ .
    Pretty much the same as mine, but with better code structure and funciton interface
 */
public class Solution2 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int maxArea = 0;
        int[][] height = new int[m][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[i][j] = matrix[i][j] == '0' ? 0 : (i == 0 ? 1 : height[i-1][j]+1);
            }
        }

        for (int i = 0; i < m; i++) {
            maxArea = Math.max(maxArea, maxAreaInHist(height[i]));
        }
        return maxArea;
    }

    private int maxAreaInHist(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty()) {
                int j = stack.peek();
                if (arr[i] > arr[j])
                    break;
                else {
                    j = stack.pop();
                    int k = -1;
                    if (!stack.isEmpty())
                        k = stack.peek();
                    int area = arr[j] * (i-1-k);
                    maxArea = Math.max(maxArea, area);
                }
            }
            stack.push(i);
        }
        return maxArea;
    }
}
