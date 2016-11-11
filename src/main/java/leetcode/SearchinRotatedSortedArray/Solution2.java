package leetcode.SearchinRotatedSortedArray;

/**
 * Created by ymyue on 6/22/16.
 * Time complexity: O(logn)
 * Space complexity: O(logn)
 */
public class Solution2 {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    private int search(int[] nums, int l, int h, int target) {
        if (l > h)
            return -1;
        int mid = l + (h-l) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[l] <= nums[mid]) {
            if (target >= nums[l] && target < nums[mid])
                return search(nums, l, mid-1, target);
            else
                return search(nums, mid+1, h, target);
        } else {
            if (target > nums[mid] && target <= nums[h])
                return search(nums, mid+1, h, target);
            else
                return search(nums, l, mid-1, target);
        }
    }
}
