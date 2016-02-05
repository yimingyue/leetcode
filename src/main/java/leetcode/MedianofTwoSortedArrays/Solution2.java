package leetcode.MedianofTwoSortedArrays;

/**
 * Created by ymyue on 11/19/15.
 */
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 0) {
            return (double)(findKth(nums1, 0, nums2, 0, (m+n)/2) + findKth(nums1, 0, nums2, 0, (m+n)/2+1)) / 2;
        } else
            return (double)findKth(nums1, 0, nums2, 0, (m+n+1)/2);
    }

    private int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        int m = nums1.length - start1;
        int n = nums2.length - start2;
        if (m == 0)
            return nums2[start2+k-1];
        if (n == 0)
            return nums1[start1+k-1];
        if (m == 1) {
            if (nums1[start1+0] < nums2[start2+k-2]) {
                return nums2[start2+k-1];
            } else if (nums1[start1+0] > nums2[start2+k-1])
                return nums2[start2+k-1];
            else
                return nums1[start1+0];
        }
        if (n == 1) {
            if (nums2[start2+0] < nums1[start1+k-2]) {
                return nums1[start1+k-1];
            } else if (nums2[start2+0] > nums1[start1+k-1])
                return nums1[start1+k-1];
            else
                return nums2[start2+0];
        }
        if (k == 1)
            return Math.min(nums1[start1+0], nums2[start2+0]);
        if (k == 2)
            return Math.max(Math.min(nums1[start1+0], nums2[start2+1]), Math.min(nums1[start1+1], nums2[start2+0]));
        int x = k * m / (m+n);
        int y = k - 1 - x;
        if (nums1[start1+x] < nums2[start2+y]) {
            start1 += x;
            k -= x;
            return findKth(nums1, start1, nums2, start2, k);
        } else {
            start2 += y;
            k -= y;
            return findKth(nums1, start1, nums2, start2, k);
        }
    }
}
