package leetcode.TwoSum;

import java.util.Map;
import java.util.HashMap;

/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                result[0] = map.get(target - num);
                result[1] = i;
                return result;
            }
            map.put(num, i);
        }
        return result;
    }
}
