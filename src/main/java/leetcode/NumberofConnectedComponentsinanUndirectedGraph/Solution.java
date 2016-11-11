package leetcode.NumberofConnectedComponentsinanUndirectedGraph;

/**
 * Created by ymyue on 6/20/16.
 * Union Find
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    class UnionFind {
        int n = 0;
        int[] parents;
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
    public int countComponents(int n, int[][] edges) {
        int count = n;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!uf.find(u, v)) {
                count--;
                uf.union(u, v);
            }
        }
        return count;
    }
}
