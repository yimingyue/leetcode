package leetcode.ShortestDistancefromAllBuildings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by ymyue on 8/2/16.
 */
public class Solution2 {
    private static final int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int[][] distance = new int[grid.length][grid[0].length];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] counts = new int[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    reset(visited);
                    helper(grid, i, j, visited, distance, counts);
                }
            }
        }

        int minLength = -1;
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                if (grid[i][j] == 0 && counts[i][j] == count) {
                    minLength = minLength == -1 ? distance[i][j] : Math.min(minLength, distance[i][j]);
                }
            }
        }
        return minLength;
    }

    private void reset(boolean[][] visited) {
        for (boolean[] row : visited)
            Arrays.fill(row, false);
    }

    private void helper(int[][] grid, int i, int j, boolean[][] visited, int[][] distance, int[][] counts) {
        int m = grid.length;
        int n = grid[0].length;
        int id = i * n + j;
        int dist = 0;
        Queue<Integer> queue = new ArrayDeque<> ();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int k = 0; k < size; k++) {
                id = queue.poll();
                i = id / n;
                j = id % n;
                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        distance[x][y] += dist;
                        counts[x][y]++;
                        queue.offer(x*n+y);
                    }
                }
            }
        }
    }
}
