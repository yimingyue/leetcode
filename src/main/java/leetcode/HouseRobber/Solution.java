package leetcode.HouseRobber;

/**
 * Created by ymyue on 10/31/15.
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length > 2)
            nums[2] += nums[0];
        for (int i = 3; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-2], nums[i-3]) + nums[i];
        }
        return Math.max(nums[nums.length-1], nums[nums.length-2]);
    }
}
