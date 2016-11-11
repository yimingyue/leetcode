package leetcode.PatchingArray;

/**
 * Created by ymyue on 7/21/16.
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        int i = 0;
        long num = 1;
        while (num <= n) {
            if (i == nums.length || nums[i] > num)
                count++;
            else
                i++;
            long end = num + num-1;
            while (i < nums.length && nums[i] <= end)
                end += nums[i++];
            num = end+1;
        }
        return count;
    }
}
