package leetcode.WiggleSort;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution2 {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i-1] > nums[i]) || (i % 2 == 0) && (nums[i-1] < nums[i]))
                swap(nums, i-1, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
