package leetcode.ContainsDuplicateII;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 6/7/15.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(val))
                return true;
            map.merge(val, 1, Integer::sum);
            if (i > k) {
                map.compute(nums[i-k-1], (x, y) -> y == 1 ? null : x - y);
            }
        }
        return false;
    }
}
