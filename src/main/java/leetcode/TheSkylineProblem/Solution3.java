package leetcode.TheSkylineProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by ymyue on 10/19/16.
 */
public class Solution3 {
    public List<int[]> getSkyline(int[][] buildings) {
        PriorityQueue<Integer> height = new PriorityQueue<>((x, y) -> y - x);
        int[][] vertical = new int[buildings.length*2][2];
        int i = 0;
        for (int[] building : buildings) {
            vertical[i][0] = building[0];
            vertical[i++][1] = building[2];
            vertical[i][0] = building[1];
            vertical[i++][1] = -building[2];
        }
        Arrays.sort(vertical, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        List<int[]> result = new ArrayList<>();
        int h = 0;
        for (int[] v : vertical) {
            if (v[1] > 0) {
                height.offer(v[1]);
            } else
                height.remove(-v[1]);
            if (height.isEmpty())
                result.add(new int[]{v[0], 0});
            else if (height.peek() != h) {
                result.add(new int[]{v[0], height.peek()});
                h = height.peek();
            }
        }
        return result;
    }
}
