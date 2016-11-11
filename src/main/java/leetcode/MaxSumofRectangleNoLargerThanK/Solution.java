package leetcode.MaxSumofRectangleNoLargerThanK;

import java.util.TreeSet;

/**
 * Created by ymyue on 7/18/16.
 * Time complexity: O(n^2*m*logm) - TLE
 */
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            throw new IllegalArgumentException();
        int m = matrix.length;
        int n = matrix[0].length;
        // m >> n

        int w = n*(n+1)/2;
        TreeSet<Integer>[] sets = new TreeSet[w];
        for (int i = 0; i < w; i++) {
            sets[i] = new TreeSet<Integer>();
            sets[i].add(0);
        }

        int maxArea = Integer.MIN_VALUE;
        int[] sums = new int[w];
        int[] rowSums = new int[w];
        for (int i = 0; i < m; i++) {
            getRowSums(rowSums, matrix[i]);
            for (int j = 0; j < w; j++) {
                sums[j] += rowSums[j];
                Integer val = sets[j].ceiling(sums[j]-k);
                if (val != null)
                    maxArea = Math.max(maxArea, sums[j] - val);
                if (maxArea == k)
                    return k;
                sets[j].add(sums[j]);
            }
        }
        return maxArea;
    }

    private void getRowSums(int[] rowSums, int[] row) {
        int w = rowSums.length;
        int n = row.length;
        if (w != n * (n+1)/2)
            throw new IllegalArgumentException();
        int sum = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            sum += row[i];
            int copy = sum;
            for (int j = 0; j <= i; j++) {
                rowSums[k++] = copy;
                copy -= row[j];
            }
        }
    }
}
