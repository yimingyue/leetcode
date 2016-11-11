package leetcode.ContainsDuplicateIII;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 7/1/16.
 * Time complexity: O(n)
 * Space complexity: O(k)
 */
public class Solution4 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || k < 1 || t < 0)
            return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long bucket = getBucket((long)nums[i], t);
            if (map.containsKey(bucket) || (map.containsKey(bucket-1) && (long)nums[i]-map.get(bucket-1) <= t)
                    || (map.containsKey(bucket+1) && map.get(bucket+1) - (long)nums[i] <= t))
                return true;
            map.put(bucket, (long)nums[i]);
            if (i >= k) {
                map.remove(getBucket(nums[i-k], t));
            }
        }
        return false;
    }

    private long getBucket(long num, int t) {
        return (num-Integer.MIN_VALUE)/((long)t+1);
    }
}
