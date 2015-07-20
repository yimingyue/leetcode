package leetcode.SortColors;

/**
 * Created by ymyue on 6/21/15.
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int i = 0, j = nums.length-1;
        while (i < j && nums[i] == 0)
            i++;
        while (i < j && nums[j] == 2)
            j--;
        int k = i;
        while (k <= j) {
            if (nums[k] == 1)
                k++;
            else if (nums[k] == 0) {
                if (i == k)
                    k++;
                else {
                    swap(nums, i, k);
                    i++;
                }
            } else if (nums[k] == 2) {
                swap(nums, j, k);
                j--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
