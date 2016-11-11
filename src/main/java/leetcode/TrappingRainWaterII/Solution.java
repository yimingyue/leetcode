package leetcode.TrappingRainWaterII;

import java.util.Arrays;

/**
 * Created by ymyue on 10/07/16.
 * Doesn't work
 */
public class Solution {
    private static final int[][] directions = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m == 0)
            return 0;
        int n = heightMap[0].length;
        int[][] minHeight = new int[m][n];
        for (int[] row : minHeight)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            dfs(heightMap, minHeight, i, 0, heightMap[i][0]);
            dfs(heightMap, minHeight, i, n-1, heightMap[i][n-1]);
        }
        for (int j = 1; j < n-1; j++) {
            dfs(heightMap, minHeight, 0, j, heightMap[0][j]);
            dfs(heightMap, minHeight, m-1, j, heightMap[m-1][j]);
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.max(0, minSurrounding(minHeight, i, j) - heightMap[i][j]);
            }
        }
        return sum;
    }

    private void dfs(int[][] heightMap, int[][] minHeight, int i, int j, int val) {
        if (i < 0 || i == heightMap.length || j < 0 || j == heightMap[i].length || heightMap[i][j] > val || minHeight[i][j] <= val)
            return;
        minHeight[i][j] = val;
        for (int[] direction : directions)
            dfs(heightMap, minHeight, i+direction[0], j+direction[1], val);
    }

    private int minSurrounding(int[][] minHeight, int i, int j) {
        int min = minHeight[i][j];
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x < 0 || x == minHeight.length || y < 0 || y == minHeight[x].length)
                continue;
            min = Math.min(min, minHeight[x][y]);
        }
        return min;
    }
}
