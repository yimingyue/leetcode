package leetcode.LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * Created by ymyue on 10/1/16.
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int maxLength = 0;
        int n = nums.length;
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(ends, 0, maxLength, nums[i]);
            if (pos < 0)
                pos = -(pos+1);
            if (pos == maxLength)
                ends[maxLength++] = nums[i];
            else
                ends[pos] = nums[i];
        }
        return maxLength;
    }
}
