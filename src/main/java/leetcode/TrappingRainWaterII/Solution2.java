package leetcode.TrappingRainWaterII;

import java.util.PriorityQueue;

/**
 * Created by ymyue on 10/8/16.
 */
public class Solution2 {
    private static final int[][] directions = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m <= 2)
            return 0;
        int n = heightMap[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<> ((i, j) -> heightMap[i/n][i%n] - heightMap[j/n][j%n]);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.offer(i*n);
            visited[i][0] = true;
            pq.offer(i*n+n-1);
            visited[i][n-1] = true;
        }

        for (int i = 1; i < n-1; i++) {
            pq.offer(i);
            visited[0][i] = true;
            pq.offer((m-1)*n+i);
            visited[m-1][i] = true;
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int id = pq.poll();
            int x = id / n;
            int y = id % n;
            for (int[] direction : directions) {
                int x1 = x + direction[0];
                if (x1 < 0 || x1 == m)
                    continue;
                int y1 = y + direction[1];
                if (y1 < 0 || y1 == n)
                    continue;
                int nid = x1 * n + y1;
                if (!visited[x1][y1]) {
                    visited[x1][y1] = true;
                    sum += Math.max(0, heightMap[x][y] - heightMap[x1][y1]);
                    heightMap[x1][y1] = Math.max(heightMap[x1][y1], heightMap[x][y]);
                    pq.offer(nid);
                }
            }
        }
        return sum;
    }
}
