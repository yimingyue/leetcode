package leetcode.NumberofIslandsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ymyue on 6/19/16.
 */
public class Solution3 {
    class UnionFind {
        int count = 0;
        int m;
        int n;
        int[] ids;
        public UnionFind(int m, int n) {
            this.m = m;
            this.n = n;
            this.ids = new int[m*n];
            Arrays.fill(ids, -1);
        }

        public void add(int u) {
            ids[u] = u;
            count++;
            if (u-n >= 0 && ids[u-n] != -1)
                union(u, u-n);
            if (u+n < m*n && ids[u+n] != -1)
                union(u, u+n);
            if (u%n != 0 && ids[u-1] != -1)
                union(u, u-1);
            if ((u+1) % n != 0 && ids[u+1] != -1)
                union(u, u+1);
        }

        public void union(int u, int v) {
            int root1 = getRoot(u);
            int root2 = getRoot(v);
            if (root1 == root2)
                return;
            count--;
            ids[root2] = root1;
        }

        public boolean find(int u, int v) { return getRoot(u) == getRoot(v); }

        private int getRoot(int id) {
            while (ids[id] != id) {
                ids[id] = ids[ids[id]];
                id = ids[id];
            }
            return id;
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> list = new ArrayList<>();
        UnionFind uf = new UnionFind(m, n);
        for (int[] position : positions) {
            uf.add(position[0] * n + position[1]);
            list.add(uf.count);
        }
        return list;
    }
}
