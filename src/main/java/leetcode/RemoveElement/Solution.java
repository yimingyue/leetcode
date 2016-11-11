package leetcode.RemoveElement;

/**
 * Created by ymyue on 6/21/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
            i++;
        }
        return j;
    }
}
