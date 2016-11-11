package leetcode.NumberofIslands;

import java.util.Arrays;

/**
 * Created by ymyue on 6/19/16.
 * Time complexity: O(mnlog(mn)
 * Space complexity: O(mn)
 */
public class Solution2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] ids = new int[m*n];
        Arrays.fill(ids, -1);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int id = getId(i, j, n);
                    ids[id] = id;
                    count++;
                    if (i > 0 && grid[i-1][j] == '1') {
                        union(ids, getId(i-1, j, n), id);
                        count--;
                    }
                    if (j > 0 && grid[i][j-1] == '1') {
                        if (getRoot(ids, getId(i, j-1, n)) != getRoot(ids, id)) {
                            union(ids, getId(i, j - 1, n), id);
                            count--;
                        }
                    }
                }
            }
        }
        return count;
    }

    private void union(int[] ids, int u, int v) {
        int root1 = getRoot(ids, u);
        int root2 = getRoot(ids, v);
        ids[root2] = root1;
    }

    private boolean find(int[] ids, int u, int v) {
        return getRoot(ids, u) == getRoot(ids, v);
    }

    private int getRoot(int[] ids, int id) {
        while (ids[id] != id) {
            ids[id] = ids[ids[id]];
            id = ids[id];
        }
        return id;
    }

    private int getId(int x, int y, int n) {
        return x * n + y;
    }

    private int getX(int id, int n) {
        return id / n;
    }

    private int getY(int id, int n) {
        return id % n;
    }
}
