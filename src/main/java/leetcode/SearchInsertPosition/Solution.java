package leetcode.SearchInsertPosition;

/**
 * Created by ymyue on 6/26/16.
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null)
            throw new IllegalArgumentException();
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }
}
