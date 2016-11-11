package leetcode.SearchinRotatedSortedArrayII;

/**
 * Created by ymyue on 6/26/16.
 * Time complexity: O(logN) worst case O(N)
 * Space complexity: O(1)
 */
public class Solution2 {
    public boolean search(int[] nums, int target) {
        if (nums == null)
            return false;
        int low = 0;
        int high = nums.length-1;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target)
                return true;
            else {
                if (nums[mid] > nums[high]) {
                    if (nums[low] <= target && target < nums[mid])
                        high = mid-1;
                    else
                        low = mid+1;
                } else if (nums[mid] < nums[high]) {
                    if (nums[mid] < target && target <= nums[high])
                        low = mid+1;
                    else
                        high = mid-1;
                } else
                    high--;
            }
        }
        return nums[low] == target;
    }
}
