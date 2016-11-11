package leetcode.FindPeakElement;

/**
 * Created by ymyue on 6/24/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();
        int i = 1;
        while (i < nums.length) {
            if (nums[i-1] > nums[i])
                return i-1;
            i++;
        }
        return i-1;
    }
}
