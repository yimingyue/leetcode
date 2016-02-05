package leetcode.ShortestDistancefromAllBuildings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ymyue on 1/8/16.
 */
public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> lands = new ArrayList<>();
        List<Integer> buildings = new ArrayList<> ();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                if (grid[i][j] == 0)
                    lands.add(k);
                else if (grid[i][j] == 1)
                    buildings.add(k);
            }
        }
        int[][] dist = new int[buildings.size()][m*n];
        for (int i = 0; i < buildings.size(); i++) {
            Arrays.fill(dist[i], m * n);
            bfs(grid, buildings.get(i), m, n, dist[i]);
        }
        return minDist(dist, lands, m, n);
    }

    private int minDist(int[][] dist, List<Integer> lands, int m, int n) {
        int min = -1;
        for (int land : lands) {
            int sum = 0;
            boolean valid = true;
            for (int i = 0; i < dist.length; i++) {
                if (dist[i][land] == m*n) {
                    valid = false;
                    break;
                }
                sum += dist[i][land];
            }
            if (!valid)
                continue;
            if (min == -1)
                min = sum;
            else
                min = Math.min(min, sum);
        }
        return min;
    }

    private void bfs(int[][] grid, int l, int m, int n, int[] dist) {
        LinkedList<Integer> queue = new LinkedList<> ();
        queue.add(l);
        int d = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            d++;
            for (int i = 0; i < count; i++) {
                int val = queue.poll();
                int x = val / n;
                int y = val % n;
                if (x > 0 && grid[x-1][y] == 0 && dist[val-n] == m*n) {
                    dist[val-n] = d;
                    queue.add(val-n);
                }
                if (x < m-1 && grid[x+1][y] == 0 && dist[val+n] == m*n) {
                    dist[val+n] = d;
                    queue.add(val+n);
                }
                if (y > 0 && grid[x][y-1] == 0 && dist[val-1] == m*n) {
                    dist[val-1] = d;
                    queue.add(val-1);
                }
                if (y < n-1 && grid[x][y+1] == 0 && dist[val+1] == m*n) {
                    dist[val+1] = d;
                    queue.add(val+1);
                }
            }
        }
    }
}
