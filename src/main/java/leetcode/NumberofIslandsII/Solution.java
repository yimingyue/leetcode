package leetcode.NumberofIslandsII;

import java.util.*;

/**
 * Created by ymyue on 1/8/16.
 */
public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> rList = new ArrayList<>();
        if (positions == null || positions.length == 0)
            return rList;
        int[] roots = new int[m*n];
        Arrays.fill(roots, -1);
        int[][] directions = new int[][] {{-1, 0},{1, 0},{0, -1},{0, 1}};
        int num = 0;
        for (int[] position : positions) {
            int root = position[0] * n + position[1];
            roots[root] = root;
            num++;
            for (int j = 0; j < directions.length; j++) {
                int x = position[0] + directions[j][0];
                int y = position[1] + directions[j][1];
                int nRoot = x * n + y;
                if (x < 0 || x == m || y < 0 || y == n || roots[nRoot] == -1)
                    continue;
                nRoot = findRoot(roots, nRoot);
                if (root != nRoot) {
                    roots[root] = nRoot;
                    root = nRoot;
                    num--;
                }
            }
            rList.add(num);
        }
        return rList;
    }

    private int findRoot(int[] roots, int root) {
        while (roots[root] != root) {
            roots[root] = roots[roots[root]];
            root = roots[root];
        }
        return root;
    }
}
