package leetcode.BombEnemy;

/**
 * Created by ymyue on 10/1/16.
 */
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        if (n == 0)
            return 0;
        int[][] counts = new int[m][n];
        int maxCount = 0;

        for (int i = 0; i < m; i++) {
            int enimies = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    enimies = 0;
                } else if (grid[i][j] == '0') {
                    counts[i][j] += enimies;
                } else
                    enimies++;
            }
        }

        for (int i = 0; i < m; i++) {
            int enimies = 0;
            for (int j = n-1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    enimies = 0;
                } else if (grid[i][j] == '0') {
                    counts[i][j] += enimies;
                } else
                    enimies++;
            }
        }

        for (int j = 0; j < n; j++) {
            int enimies = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'W') {
                    enimies = 0;
                } else if (grid[i][j] == '0') {
                    counts[i][j] += enimies;
                } else
                    enimies++;
            }
        }

        for (int j = 0; j < n; j++) {
            int enimies = 0;
            for (int i = m-1; i >= 0; i--) {
                if (grid[i][j] == 'W') {
                    enimies = 0;
                } else if (grid[i][j] == '0') {
                    counts[i][j] += enimies;
                    maxCount = Math.max(maxCount, counts[i][j]);
                }
                else
                    enimies++;
            }
        }
        return maxCount;
    }
}
