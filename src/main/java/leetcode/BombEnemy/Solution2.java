package leetcode.BombEnemy;

/**
 * Created by ymyue on 10/16/16.
 */
public class Solution2 {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] col = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            int row = 0;
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j-1] == 'W') {
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        row += grid[i][k] == 'E' ? 1 : 0;
                    }
                }
                if (i == 0 || grid[i-1][j] == 'W') {
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        col[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                if (grid[i][j] == '0') {
                    max = Math.max(max, col[j] + row);
                }
            }
        }
        return max;
    }
}
