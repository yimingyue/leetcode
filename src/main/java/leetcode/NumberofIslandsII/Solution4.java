package leetcode.NumberofIslandsII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ymyue on 10/21/16.
 */
public class Solution4 {
    private int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> root = new HashMap<>();
        int count = 0;
        for (int[] position : positions) {
            int id = position[0] * n + position[1];
            root.put(id, id);
            count++;
            for (int[] direction : directions) {
                int x = direction[0] + position[0];
                int y = direction[1] + position[1];
                if (x < 0 || x == m || y < 0 || y == n)
                    continue;
                int nid = x * n + y;
                if (root.containsKey(nid)) {
                    int root1 = getRoot(root, id);
                    int root2 = getRoot(root, nid);
                    if (root1 != root2) {
                        count--;
                        root.put(root2, root1);
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private int getRoot(Map<Integer, Integer> root, int id) {
        while (root.get(id) != id) {
            root.put(id, root.get(root.get(id)));
            id = root.get(id);
        }
        return id;
    }
}
