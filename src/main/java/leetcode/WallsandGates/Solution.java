package leetcode.WallsandGates;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution {
    private static final int[][] directions = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0)
                    queue.offer(new int[]{i, j});
            }
        }

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] direction : directions) {
                    int x = cur[0] + direction[0];
                    int y = cur[1] + direction[1];
                    if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[x].length && rooms[x][y] == Integer.MAX_VALUE) {
                        rooms[x][y] = level;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
