package leetcode.WiggleSort;

/**
 * Created by ymyue on 6/5/16.
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i += 2) {
            if (i < nums.length-1 && nums[i] > nums[i+1])
                swap(nums, i, i+1);
            if (i > 0 && nums[i] > nums[i-1])
                swap(nums, i, i-1);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
