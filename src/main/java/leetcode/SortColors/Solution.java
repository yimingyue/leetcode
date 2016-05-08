package leetcode.SortColors;

/**
 * Created by ymyue on 6/21/15.
 */
public class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 2 && k < j)
                swap(nums, k, j--);
            if (nums[k] == 0 && k > i)
                swap(nums, k, i++);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
