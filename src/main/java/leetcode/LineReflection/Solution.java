package leetcode.LineReflection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ymyue on 6/14/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    public boolean isReflected(int[][] points) {
        if (points == null || points.length < 2)
            return true;
        int max = points[0][0];
        int min = points[0][0];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            map.putIfAbsent(p[0], new HashSet<Integer>());
            map.get(p[0]).add(p[1]);
        }
        for (int[] p : points) {
            if (!map.containsKey(max - (p[0]-min)) || !map.get(max - (p[0]-min)).contains(p[1]))
                return false;
        }
        return true;
    }
}
