package leetcode.SpiralMatrixII;

/**
 * Created by ymyue on 6/20/15.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0)
            return null;
        int[][] matrix = new int[n][n];
        if (n == 0)
            return matrix;
        int l = n / 2;
        int count = 1;
        for (int i = 0; i < l; i++) {
            for (int j = i; j < n-i-1; j++) {
                matrix[i][j] = count++;
            }
            for (int j = i; j < n-i-1; j++) {
                matrix[j][n-1-i] = count++;
            }
            for (int j = i; j < n-i-1; j++) {
                matrix[n-1-i][n-1-j] = count++;
            }
            for (int j = i; j < n-i-1; j++) {
                matrix[n-1-j][i] = count++;
            }
        }
        if (n % 2 == 1)
            matrix[n/2][n/2] = count++;
        return matrix;
    }
}
