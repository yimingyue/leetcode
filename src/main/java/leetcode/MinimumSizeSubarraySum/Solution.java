package leetcode.MinimumSizeSubarraySum;

/**
 * Created by ymyue on 6/27/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = nums.length+1;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (i < nums.length) {
            sum += nums[i];
            while (sum >= s) {
                minLen = Math.min(minLen, i-j+1);
                sum -= nums[j++];
            }
            i++;
        }
        return minLen == nums.length+1 ? 0 : minLen;
    }
}
