package leetcode.BestMeetingPoint;

import java.util.Arrays;

/**
 * Created by ymyue on 6/5/16.
 * Straightforward solution
 * Time complexity O(mnk)
 * Space complexity O(mn)
 */
public class Solution2 {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, 0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    updateDist(dist, i, j);
            }
        }
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minDist = Math.min(minDist, dist[i][j]);
            }
        }
        return minDist;
    }

    private void updateDist(int[][] dist, int i, int j) {
        for (int m = 0; m < dist.length; m++) {
            for (int n = 0; n < dist[m].length; n++) {
                dist[m][n] += Math.abs(m-i) + Math.abs(n-j);
            }
        }
    }
}
