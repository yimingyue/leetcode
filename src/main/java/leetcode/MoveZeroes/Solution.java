package leetcode.MoveZeroes;

/**
 * Created by ymyue on 6/21/16.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] != 0)
                nums[j++] = nums[i];
            i++;
        }
        while (j < nums.length)
            nums[j++] = 0;
    }
}
