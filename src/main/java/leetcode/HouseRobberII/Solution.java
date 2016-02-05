package leetcode.HouseRobberII;

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length-1; i++) {
            int max = Math.max(first + nums[i], second);
            first = second;
            second = max;
        }
        int maxFirst = second;
        first = nums[1];
        second = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            int max = Math.max(first + nums[i], second);
            first = second;
            second = max;
        }
        return Math.max(maxFirst, second);
    }
}
