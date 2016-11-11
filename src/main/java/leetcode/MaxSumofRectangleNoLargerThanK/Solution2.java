package leetcode.MaxSumofRectangleNoLargerThanK;

import java.util.TreeSet;

/**
 * Created by ymyue on 7/18/16.
 * https://discuss.leetcode.com/topic/48875/accepted-c-codes-with-explanation-and-references/5
 * Time complexity: O(n^2*m*logm)
 */
public class Solution2 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            throw new IllegalArgumentException();
        int m = matrix.length;
        int n = matrix[0].length;

        int maxSum = Integer.MIN_VALUE;
        for (int left = 0; left < n; left++) {
            int[] sums = new int[m];
            for (int right = left; right < n; right++) {
                for (int row = 0; row < m; row++) {
                    sums[row] += matrix[row][right];
                }

                TreeSet<Integer> set = new TreeSet<> ();
                set.add(0);
                int s = 0;
                for (int sum : sums) {
                    s += sum;
                    Integer val = set.ceiling(s - k);
                    if (val != null)
                        maxSum = Math.max(maxSum, s - val);
                    if (maxSum == k)
                        return maxSum;
                    set.add(s);
                }
            }
        }
        return maxSum;
    }
}
