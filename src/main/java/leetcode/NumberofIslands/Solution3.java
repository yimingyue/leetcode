package leetcode.NumberofIslands;

import com.sun.tools.javac.util.Assert;

/**
 * Created by ymyue on 6/19/16.
 * https://leetcode.com/discuss/107399/easy-to-understand-simplify-java-union-find-version
 */
public class Solution3 {
    private class UnionFind {
        int count;
        int[] ids;
        int m = 0;
        int n = 0;
        public UnionFind(char[][] grid) {
            Assert.checkNonNull(grid);
            m = grid.length;
            n = grid[0].length;
            count = 0;
            ids = new int[m*n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        ids[i * n + j] = i * n + j;
                        count++;
                    } else
                        ids[i*n+j] = -1;
                }
            }
        }

        public void union(int u, int v) {
            int root1 = getRoot(u);
            int root2 = getRoot(v);
            if (root1 != root2) {
                count--;
                ids[root2] = root1;
            }
        }

        public boolean find(int u, int v) {
            return getRoot(u) == getRoot(v);
        }

        private int getRoot(int id) {
            while (ids[id] != id) {
                ids[id] = ids[ids[id]];
                id = ids[id];
            }
            return id;
        }

        public int getCount() { return count; }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        UnionFind uf = new UnionFind(grid);
        int n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i-1][j] == '1')
                        uf.union((i-1)*n+j, i*n+j);
                    if (j > 0 && grid[i][j-1] == '1')
                        uf.union(i*n+j-1, i*n+j);
                }
            }
        }
        return uf.getCount();
    }
}
