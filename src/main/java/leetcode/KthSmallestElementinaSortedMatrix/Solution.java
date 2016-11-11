package leetcode.KthSmallestElementinaSortedMatrix;

import java.util.PriorityQueue;

/**
 * Created by ymyue on 9/7/16.
 * Time complexity: O(k*logn)
 * Space complexity: O(n^2)
 */

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0)
            throw new IllegalArgumentException("Input Matrix Empty!");

        PriorityQueue<Integer> pq = new PriorityQueue<> (n, (x, y) -> {
            int x0 = x/n;
            int y0 = x%n;
            int x1 = y/n;
            int y1 = y%n;
            return matrix[x0][y0] - matrix[x1][y1];
        });

        boolean[][] visited = new boolean[n][n];
        pq.offer(0);
        int x = 0;
        int y = 0;
        while (k-- > 0) {
            int id = pq.poll();
            x = id / n;
            y = id % n;
            if (x < n-1 && !visited[x+1][y]) {
                visited[x+1][y] = true;
                pq.offer(id+n);
            }
            if (y < n-1 && !visited[x][y+1]) {
                visited[x][y+1] = true;
                pq.offer(id+1);
            }
        }
        return matrix[x][y];
    }
}
