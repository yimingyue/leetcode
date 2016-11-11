package leetcode.MedianofTwoSortedArrays;

/**
 * Created by ymyue on 6/21/16.
 */
public class Solution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        return findMedianSortedArrays(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1);
    }

    private double findMedianSortedArrays(int[] nums1, int l1, int h1, int[] nums2, int l2, int h2) {
        if (l1 > h1)
            return getMedian(nums2, l2, h2);
        else if (l1 == h1) {
            if (l2 == h2) {
                return ((double)nums1[l1] + (double)nums2[l2]) / 2;
            } else if ((h2-l2)%2 == 1) {
                if (nums1[l1] >= nums2[l2+(h2-l2)/2] && nums1[l1] <= nums2[l2+(h2-l2+1)/2])
                    return nums1[l1];
                else if (nums1[l1] < nums2[l2+(h2-l2)/2])
                    return nums2[l2+(h2-l2)/2];
                else
                    return nums2[l2+(h2-l2+1)/2];
            } else {
                if (nums1[l1] <= nums2[l2+(h2-l2)/2-1])
                    return ((double)nums2[l2+(h2-l2)/2-1] + (double)nums2[l2+(h2-l2)/2]) / 2;
                else if (nums1[l1] <= nums2[l2+(h2-l2)/2+1])
                    return ((double)nums1[l1] + (double)nums2[l2+(h2-l2)/2]) / 2;
                else
                    return ((double)nums2[l2+(h2-l2)/2] + (double)nums2[l2+(h2-l2)/2+1]) / 2;
            }
        } else {
            double median1 = getMedian(nums1, l1, h1);
            double median2 = getMedian(nums2, l2, h2);
            if (median1 == median2)
                return median1;
            else if (median1 < median2) {
                return findMedianSortedArrays(nums1, l1+(h1-l1+1)/2, h1, nums2, l2, h2-(h1-l1+1)/2);
            } else
                return findMedianSortedArrays(nums1, l1, l1+(h1-l1-1)/2, nums2, l2 + h1-l1-(h1-l1-1)/2, h2);
        }
    }

    private double getMedian(int[] nums, int l, int h) {
        return ((double)nums[l+(h-l)/2] + (double)nums[l+(h-l+1)/2]) / 2;
    }
}
