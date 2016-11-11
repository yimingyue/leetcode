package leetcode.BombEnemy;

/**
 * Created by ymyue on 7/31/16.
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 */
public class MySolution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            int c = 0;
            int k = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'E')
                    c++;
                else if (grid[i][j] == 'W') {
                    while (k < j) {
                        if (grid[i][k] == '0')
                            count[i][k] += c;
                        k++;
                    }
                    c = 0;
                }
            }
            while (k < n) {
                if (grid[i][k] == '0')
                    count[i][k] += c;
                k++;
            }
        }

        int maxCount = 0;
        for (int j = 0; j < n; j++) {
            int c = 0;
            int k = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'E')
                    c++;
                else if (grid[i][j] == 'W') {
                    while (k < i) {
                        if (grid[k][j] == '0') {
                            count[k][j] += c;
                            maxCount = Math.max(maxCount, count[k][j]);
                        }
                        k++;
                    }
                    c = 0;
                }
            }
            while (k < m) {
                if (grid[k][j] == '0') {
                    count[k][j] += c;
                    maxCount = Math.max(maxCount, count[k][j]);
                }
                k++;
            }
        }
        return maxCount;
    }
}
