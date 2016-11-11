package leetcode.MaximumSizeSubarraySumEqualsk;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 6/12/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k)
                maxLen = i+1;
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
