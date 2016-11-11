package leetcode.SurroundedRegions;

import java.util.Arrays;

/**
 * Created by ymyue on 6/20/16.
 * UnionFind
 * Time complexity: O(mn?)
 * Space complexity: O(mn)
 */
public class Solution2 {
    class UnionFind {
        int[] ids;
        boolean[] surrounded;
        int m;
        int n;
        public UnionFind(int m, int n) {
            this.m = m;
            this.n = n;
            ids = new int[m*n];
            Arrays.fill(ids, -1);
            surrounded = new boolean[m*n];
            Arrays.fill(surrounded, true);
        }

        public void add(int u) {
            ids[u] = u;
            if (u/n == 0 || u/n == m-1 || u%n == 0 || u%n == n-1)
                surrounded[u] = false;
            if (u-n >= 0 && ids[u-n] != -1)
                union(u-n, u);
            if (u+n < m*n && ids[u+n] != -1)
                union(u, u+n);
            if (u%n != 0 && ids[u-1] != -1)
                union(u-1, u);
            if ((u+1)%n != 0 && ids[u+1] != -1)
                union(u, u+1);
        }

        private void union(int u, int v) {
            int root1 = getRoot(u);
            int root2 = getRoot(v);
            ids[root2] = root1;
            surrounded[root1] &= surrounded[root2];
        }

        private int getRoot(int u) {
            while (ids[u] != u) {
                ids[u] = ids[ids[u]];
                u = ids[u];
            }
            return u;
        }

        public boolean isSurrounded(int u) {
            return surrounded[getRoot(u)];
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        UnionFind uf = new UnionFind(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    uf.add(i*n+j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (uf.isSurrounded(i*n+j))
                        board[i][j] = 'X';
                }
            }
        }
    }
}
