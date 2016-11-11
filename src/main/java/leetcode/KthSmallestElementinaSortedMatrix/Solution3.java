package leetcode.KthSmallestElementinaSortedMatrix;

import java.util.PriorityQueue;

/**
 * Created by ymyue on 9/7/16.
 */
public class Solution3 {
    class Pair implements Comparable<Pair> {
        int x;
        int y;
        int val;
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int compareTo(Pair p) {
            return this.val - p.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0)
            throw new IllegalArgumentException("Input Matrix Empty!");

        PriorityQueue<Pair> pq = new PriorityQueue<> (n, (p, q) -> matrix[p.x][p.y] - matrix[q.x][q.y]);

        for (int i = 0; i < n; i++)
            pq.offer(new Pair(0, i, matrix[0][i]));
        int x = 0;
        int y = 0;
        while (k-- > 0) {
            Pair p = pq.poll();
            x = p.x;
            y = p.y;
            if (x < n-1)
                pq.offer(new Pair(x+1, y, matrix[x+1][y]));
        }
        return matrix[x][y];
    }
}
