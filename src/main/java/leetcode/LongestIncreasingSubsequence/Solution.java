package leetcode.LongestIncreasingSubsequence;

/**
 * Created by ymyue on 6/27/16.
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] ends = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int low = 0;
            int high = len-1;
            while (low <= high) {
                int mid = low + (high-low)/2;
                if (num == ends[mid]) {
                    low = mid;
                    break;
                } else if (num < ends[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            if (low == len) {
                ends[len++] = num;
            } else{
                ends[low] = num;
            }
        }
        return len;
    }
}
