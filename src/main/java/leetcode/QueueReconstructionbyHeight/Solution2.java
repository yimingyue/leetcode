package leetcode.QueueReconstructionbyHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ymyue on 10/22/16.
 */
public class Solution2 {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(people, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
        for (int[] p : people)
            result.add(p[1], p);
        return result.toArray(new int[people.length][]);
    }
}
