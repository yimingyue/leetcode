package leetcode.FindPeakElement;

/**
 * Created by ymyue on 6/24/16.
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
public class Solution2 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();
        int low = 0;
        int high = nums.length-1;
        while (low < high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
}
