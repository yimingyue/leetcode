package leetcode.ProductofArrayExceptSelf;

/**
 * Created by ymyue on 6/23/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2)
            throw new IllegalArgumentException("Input array size must be larger than 1!");
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++)
            res[i] = res[i-1] * nums[i-1];
        int product = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            res[i] = res[i] * product;
            product *= nums[i];
        }
        return res;
    }
}
