package leetcode.WallsandGates;

import java.util.LinkedList;

/**
 * Created by ymyue on 1/7/16.
 * Time complexity: O(mn)
 * Space complexity: O(mn)
 */
public class SolutionBFS {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;
        int m = rooms.length;
        int n = rooms[0].length;
        int inf = 2147483647;
        LinkedList<Integer> queue = new LinkedList<> ();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0)
                    queue.add(i*n+j);
            }
        }
        int dist = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            dist++;
            for (int k = 0; k < count; k++) {
                int val = queue.poll();
                int i = val / n;
                int j = val % n;
                if (i > 0 && rooms[i-1][j] == inf) {
                    rooms[i-1][j] = dist;
                    queue.add(val - n);
                }
                if (i < m-1 && rooms[i+1][j] == inf) {
                    rooms[i+1][j] = dist;
                    queue.add(val + n);
                }
                if (j > 0 && rooms[i][j-1] == inf) {
                    rooms[i][j-1] = dist;
                    queue.add(val - 1);
                }
                if (j < n-1 && rooms[i][j+1] == inf) {
                    rooms[i][j+1] = dist;
                    queue.add(val + 1);
                }
            }
        }
    }
}
