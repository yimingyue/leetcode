package leetcode.NumberofIslandsII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 2/14/16.
 */
public class Solution2 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] ids = new int[m*n];
        boolean[] isIsland = new boolean[m*n];
        List<Integer> list = new ArrayList<> ();
        int count = 0;
        int[][]offsets = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        for (int[] position : positions) {
            int id = position[0] * n + position[1];
            if (isIsland[id]) {
                list.add(count);
                continue;
            }
            ids[id] = id;
            isIsland[id] = true;
            count++;
            for (int[] offset : offsets) {
                int x = position[0] + offset[0];
                if (x < 0 || x >= m)
                    continue;
                int y = position[1] + offset[1];
                if (y < 0 || y >= n)
                    continue;
                int nId = x*n+y;
                if (isIsland[nId]) {
                    int root = find(ids, nId);
                    if (root != id) {
                        count--;
                        ids[root] = id;
                    }
                }
            }
            list.add(count);
        }
        return list;
    }

    private int find(int[] ids, int id) {
        while (ids[id] != id) {
            ids[id] = ids[ids[id]];
            id = ids[id];
        }
        return id;
    }
}
