package leetcode.SparseMatrixMultiplication;

/**
 * Created by ymyue on 6/12/16.
 */
public class Solution2 {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int k = B[0].length;

        int[][] C = new int[m][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int t = 0; t < k; t++) {
                        if (B[j][t] != 0)
                            C[i][t] += A[i][j] * B[j][t];
                    }
                }
            }
        }
        return C;
    }
}
