package leetcode.RemoveDuplicatesfromSortedArray;

/**
 * Created by ymyue on 6/21/16.
 * Time complexity: O(n）
 * Space complexity: O(1)
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 1;
        int j = 1;
        while (i < nums.length) {
            if (nums[i] != nums[i-1])
                nums[j++] = nums[i];
            i++;
        }
        return j;
    }
}
