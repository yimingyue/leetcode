package leetcode.LongestIncreasingPathinaMatrix;

/**
 * Created by ymyue on 7/11/16.
 * Time complexity: O(mn)
 * Space complexity: O(mn)
 */
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int maxLength = 0;
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] lengthMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, longestIncreasingPath(matrix, i, j, lengthMatrix));
            }
        }
        return maxLength;
    }

    private int longestIncreasingPath(int[][] matrix, int i, int j, int[][] lengthMatrix) {
        if (lengthMatrix[i][j] != 0)
            return lengthMatrix[i][j];
        int maxLength = 1;
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x < 0 || x == matrix.length || y < 0 || y == matrix[x].length || matrix[i][j] >= matrix[x][y])
                continue;
            maxLength = Math.max(maxLength, 1+longestIncreasingPath(matrix, x, y, lengthMatrix));
        }
        lengthMatrix[i][j] = maxLength;
        return maxLength;
    }
}
