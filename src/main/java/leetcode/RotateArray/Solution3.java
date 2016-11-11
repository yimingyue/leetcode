package leetcode.RotateArray;

/**
 * Created by ymyue on 6/21/16.
 * Time complexity: O(2N)
 * Space complexity: O(1)
 */
public class Solution3 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
