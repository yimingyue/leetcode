package leetcode.SearchinRotatedSortedArrayII;

/**
 * Created by ymyue on 6/21/15.
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        return search(nums, target, 0, nums.length-1);
    }

    public boolean search(int[] nums, int target, int start, int end) {
        if (start > end)
            return false;
        if (start == end)
            return nums[start] == target;
        while (start < end && nums[start] == nums[start+1])
            start++;
        while (end > start && nums[end] == nums[end-1])
            end--;
        if (start == end - 1)
            return nums[start] == target || nums[end] == target;
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return true;
        if (nums[start] < nums[mid] && nums[mid] < nums[end]) {
            if (target < nums[mid])
                return search(nums, target, start, mid-1);
            else
                return search(nums, target, mid+1, end);
        } else if (nums[start] < nums[mid] && nums[mid] > nums[end]) {
            if (nums[start] <= target && target < nums[mid])
                return search(nums, target, start, mid-1);
            else
                return search(nums, target, mid+1, end);
        } else {
            if (nums[mid] < target && target <= nums[end])
                return search(nums, target, mid+1, end);
            else
                return search(nums, target, start, mid-1);
        }
    }
}
