package leetcode.RotateImage;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/21/14
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n == 1)
            return;

        int level = n/2;
        for (int i = 0; i < level; i++) {
            for (int j = i; j < n-1-i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
}
