package leetcode.ShortestDistancefromAllBuildings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution3 {
    private static final int[][] directions = new int[][] {
            {0, 1}, {0, -1}, {-1, 0}, {1, 0}
    };

    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return -1;
        int[][] dist = new int[grid.length][grid[0].length];
        int start = 0;
        int min = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    min = bfs(grid, dist, i, j, start--);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int bfs(int[][] grid, int[][] dist, int i, int j, int start) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        int level = 0;
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                for (int[] direction : directions) {
                    int x = cur[0] + direction[0];
                    int y = cur[1] + direction[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == start) {
                        grid[x][y]--;
                        dist[x][y] += level;
                        min = Math.min(min, dist[x][y]);
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return min;
    }
}
