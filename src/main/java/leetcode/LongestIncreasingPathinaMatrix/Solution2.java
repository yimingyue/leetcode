package leetcode.LongestIncreasingPathinaMatrix;

/**
 * Created by ymyue on 8/1/16.
 */
public class Solution2 {
    private static final int[][] directions = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int[][] dist = new int[matrix.length][matrix[0].length];
        int maxDist = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (dist[i][j] != 0)
                    maxDist = Math.max(maxDist, longestIncreasingPath(matrix, i, j, dist));
            }
        }
        return maxDist + 1;
    }

    private int longestIncreasingPath(int[][] matrix, int i, int j, int[][] dist) {
        int maxDist = dist[i][j];
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[x].length && matrix[i][j] < matrix[x][y] && dist[i][j] >= dist[x][y]) {
                dist[x][y] = dist[i][j] + 1;
                maxDist = Math.max(maxDist, longestIncreasingPath(matrix, x, y, dist));
            }
        }
        return maxDist;
    }
}
