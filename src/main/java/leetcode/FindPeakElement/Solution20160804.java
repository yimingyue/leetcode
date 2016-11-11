package leetcode.FindPeakElement;

/**
 * Created by ymyue on 8/4/16.
 */
public class Solution20160804 {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length-1);
    }

    private int findPeakElement(int[] nums, int start, int end) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1]))
            return mid;
        else {
            int peak =  findPeakElement(nums, start, mid-1);
            return peak != -1 ? peak : findPeakElement(nums, mid+1, end);
        }
    }
}
