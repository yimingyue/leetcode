package leetcode.ContainsDuplicateIII;

import java.util.TreeSet;

/**
 * Created by ymyue on 7/1/16.
 * Time complexity: O(nlogK)
 * Space complexity: O(k)
 */
public class Solution3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || k < 1 || t < 0)
            return false;
        TreeSet<Long> tree = new TreeSet<> ();
        for (int i = 0; i < nums.length; i++) {
            Long floor = tree.floor((long)nums[i]+t);
            Long ceil = tree.ceiling((long)nums[i]-t);
            if ((floor != null && floor >= ((long)nums[i] - t)) ||
                    (ceil != null && ceil <= (long)nums[i]+t))
                return true;
            tree.add((long)nums[i]);
            if (i >= k)
                tree.remove((long)nums[i-k]);
        }
        return false;
    }
}
