package leetcode.GraphValidTree;

/**
 * Created by ymyue on 6/20/16.
 * UnionFind
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution2 {
    class UnionFind {
        int[] parents;
        int n = 0;
        public UnionFind(int n) {
            this.n = n;
            parents = new int[n];
            for (int i = 0; i < n; i++)
                parents[i] = i;
        }

        public void union(int u, int v) {
            int root1 = getRoot(u);
            int root2 = getRoot(v);
            parents[root2] = root1;
        }

        public boolean find(int u, int v) {
            return getRoot(u) == getRoot(v);
        }

        private int getRoot(int u) {
            while (parents[u] != u) {
                parents[u] = parents[parents[u]];
                u = parents[u];
            }
            return u;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        if (n == 0)
            return true;
        UnionFind uf = new UnionFind(n);
        int count = n;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (uf.find(u, v))
                return false;
            count--;
            uf.union(u, v);
        }
        return count == 1;
    }
}
