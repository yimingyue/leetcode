package leetcode.NextPermutation;

/**
 * Created by ymyue on 7/10/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        int j = nums.length-2;
        while (j >= 0 && nums[j] >= nums[j+1])
            j--;
        if (j >= 0) {
            int i = nums.length-1;
            while (i > j && nums[i] <= nums[j])
                i--;
            swap(nums, i, j);
        }
        reverse(nums, j+1, nums.length-1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j)
            swap(nums, i++, j--);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
