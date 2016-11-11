package leetcode.ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 6/7/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            if (!set.add(num))
                return true;
        return false;
    }
}
