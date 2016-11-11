package leetcode.WiggleSubsequence;

/**
 * Created by ymyue on 9/18/16.
 * Last modified by ymyue on 9/18/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0)
            return 0;
        int count = 1;
        int i = 1;
        while (i < nums.length && nums[i] == nums[i-1])
            i++;
        if (i == nums.length)
            return 1;
        boolean positive = (nums[i] - nums[i-1]) > 0;
        int j = i-1;
        while (i < nums.length) {
            if (nums[i] != nums[j]) {
                if ((nums[i] < nums[j] && !positive) || (nums[i] > nums[j] && positive)) {
                    count++;
                    positive = !positive;
                }
                j = i;
            }
            i++;
        }
        return count;
    }
}
