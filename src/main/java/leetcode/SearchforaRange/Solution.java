package leetcode.SearchforaRange;

/**
 * Created by ymyue on 6/26/16.
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] {-1, -1};
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        int lowEnd = low;
        low = 0;
        high = nums.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        int highEnd = high;
        return lowEnd > highEnd ? new int[] {-1, -1} : new int[] {lowEnd, highEnd};
    }
}
