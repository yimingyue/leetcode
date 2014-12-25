package AppAnnie.ShortestPath.ShortestPath;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 6/8/14
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public boolean shortestPath(boolean [][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        if (!matrix[0][0])
            return false;
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> set = new HashSet<>();
        set.add(0);
        int step = 0;
        boolean [] visited = new boolean[m*n];
        int [] ancestor = new int[m*n];
        visited[0] = true;
        ancestor[0] = -1;
        while (!set.isEmpty()) {
            Set<Integer> newSet = new HashSet<>();
            step++;
            for (int v : set) {
                int i = v / n;
                int j = v % n;
                if (i > 0) {
                    int u = (i-1)*n+j;
                    if (!visited[u]) {
                        ancestor[u] = v;
                        visited[u] = true;
                        newSet.add(u);
                    }
                }
                if (i < m-1) {
                    int u = (i+1)*n+j;
                    if (!visited[u]) {
                        ancestor[u] = v;
                        visited[u] = true;
                        newSet.add(u);
                        if (u == m*n-1) {
                            int k = ancestor[u];
                            while (k != -1) {
                                System.out.println(k);
                                k = ancestor[k];
                            }
                            return true;
                        }
                    }
                }
                if (j > 0) {
                    int u = i*n+j-1;
                    if (!visited[u]) {
                        ancestor[u] = v;
                        visited[u] = true;
                        newSet.add(u);
                    }
                }
                if (j < n-1) {
                    int u = i*n+j+1;
                    if (!visited[u]) {
                        ancestor[u] = v;
                        visited[u] = true;
                        newSet.add(u);
                        if (u == m*n-1) {
                            int k = ancestor[u];
                            while (k != -1) {
                                System.out.println(k);
                                k = ancestor[k];
                            }
                            return true;
                        }
                    }
                }
            }
            set = newSet;
        }
        return false;
    }
}
