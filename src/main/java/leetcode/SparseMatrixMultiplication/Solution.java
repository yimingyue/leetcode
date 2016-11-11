package leetcode.SparseMatrixMultiplication;

import java.util.Arrays;

/**
 * Created by ymyue on 6/12/16.
 */
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = B.length;
        if (n == 0)
            throw new IllegalArgumentException();
        int k = B[0].length;
        boolean[] zeroRows = new boolean[m];
        boolean[] zeroCols = new boolean[k];

        Arrays.fill(zeroRows, true);
        Arrays.fill(zeroCols, true);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    zeroRows[i] = false;
                    continue;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (B[j][i] != 0) {
                    zeroCols[i] = false;
                    continue;
                }
            }
        }

        int[][] result = new int[m][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                if (zeroRows[i] || zeroCols[j])
                    result[i][j] = 0;
                else {
                    int sum = 0;
                    for (int t = 0; t < n; t++)
                        sum += A[i][t] * B[t][j];
                    result[i][j] = sum;
                }
            }
        }
        return result;
    }
}
