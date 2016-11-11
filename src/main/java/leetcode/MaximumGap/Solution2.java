package leetcode.MaximumGap;

import leetcode.common.utils.Radix;

/**
 * Created by ymyue on 6/4/16.
 * Radix sort
 */
public class Solution2 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Radix.radixSort(nums);
        int maxGap = 0;
        for (int i = 1; i < nums.length; i++)
            maxGap = Math.max(maxGap, nums[i] - nums[i-1]);
        return maxGap;
    }
}
