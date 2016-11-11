package leetcode.NextPermutation;

/**
 * Created by ymyue on 10/21/16.
 */
public class Solution2 {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while (i > 0 && nums[i] >= nums[i-1])
            i--;
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int j = nums.length-1;
        while (nums[j] <= nums[i])
            j--;
        swap(nums, i, j);
        reverse(nums, j, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
