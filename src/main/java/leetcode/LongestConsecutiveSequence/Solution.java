package leetcode.LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 6/20/16.
 * Time complexity: O(n?)
 * Space complexity: O(n)
 */

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<> ();
        int maxCount = 1;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, num);
                count.put(num, 1);
                if (map.containsKey(num-1)) {
                    int root1 = getRoot(map, num-1);
                    int root2 = num;
                    map.put(root2, root1);
                    count.put(root1, count.get(root1) + count.get(root2));
                    maxCount = Math.max(maxCount, count.get(root1));
                }
                if (map.containsKey(num+1)) {
                    int root1 = getRoot(map, num);
                    int root2 = getRoot(map, num+1);
                    map.put(root2, root1);
                    count.put(root1, count.get(root1) + count.get(root2));
                    maxCount = Math.max(maxCount, count.get(root1));
                }
            }
        }
        return maxCount;
    }

    private int getRoot(Map<Integer, Integer> map, int id) {
        while (map.get(id) != id) {
            map.put(id, map.get(map.get(id)));
            id = map.get(id);
        }
        return id;
    }
}
