package leetcode.FindMinimuminRotatedSortedArray;

/**
 * Created by ymyue on 6/21/16.
 * Time complexity: O(logn)
 * Space complexity: O(logn)
 */
public class Solution2 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }

    private int findMin(int[] nums, int l, int h) {
        if (l == h)
            return nums[l];
        if (nums[l] < nums[h])
            return nums[l];
        int mid = l + (h-l)/2;
        if (nums[mid] < nums[h]) {
            return findMin(nums, l, mid);
        } else {
            return findMin(nums, mid+1, h);
        }
    }
}
