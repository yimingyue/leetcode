package leetcode.ContainsDuplicateII;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 6/7/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (i >= k)
                set.remove(nums[i-k]);
        }
        return false;
    }
}
