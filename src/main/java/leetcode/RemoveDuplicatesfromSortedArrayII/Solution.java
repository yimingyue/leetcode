package leetcode.RemoveDuplicatesfromSortedArrayII;

/**
 * Created by ymyue on 6/21/15.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int i = 2;
        int j = 0;
        int a = nums[0], b = nums[1];
        while (i < nums.length) {
            if (nums[i] == nums[i-2]) {
                i++;
            } else
                nums[j++] = nums[i++];
        }
        for (i = j+1; i >= 2; i--)
            nums[i] = nums[i-2];
        nums[0] = a;
        nums[1] = b;
        return j + 2;
    }
}
