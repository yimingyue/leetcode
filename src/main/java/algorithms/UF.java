package algorithms;

/**
 * Created by ymyue on 6/16/16.
 * Union Find - https://class.coursera.org/algs4partI-010/lecture/5
 */
public class UF {
    private int[] id;
    public UF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    private void union(int u, int v) {
        int i = getRoot(u);
        int j = getRoot(v);
        id[j] = i;
    }

    private boolean find(int u, int v) {
        return getRoot(u) == getRoot(v);
    }

    private int getRoot(int u) {
        while (u != id[u]) {
            id[u] = id[id[u]];
            u = id[u];
        }
        return u;
    }
}
