package leetcode.TwoSum;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                arr[0] = map.get(target - nums[i]);
                arr[1] = i + 1;
                return arr;
            }
            map.put(nums[i], i+1);
        }
        return arr;
    }
}
