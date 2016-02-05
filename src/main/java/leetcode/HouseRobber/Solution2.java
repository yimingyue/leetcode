package leetcode.HouseRobber;

public class Solution2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < sum.length; i++) 
            sum[i] = Math.max(nums[i] + sum[i-2], sum[i-1]);
        return sum[sum.length-1];
    }
}
