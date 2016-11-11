package leetcode.MedianofTwoSortedArrays;

/**
 * Created by ymyue on 10/19/16.
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = m;
        while (low <= high) {
            int i = low + (high-low) / 2;
            int j = (m+n+1)/2-i;
            if (i < m && nums2[j-1] > nums1[i])
                low = i+1;
            else if (i > 0 && nums1[i-1] > nums2[j])
                high = i-1;
            else {
                int maxLeft = 0;
                if (i == 0)
                    maxLeft = nums2[j-1];
                else if (j == 0)
                    maxLeft = nums1[i-1];
                else
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                if ((m + n) % 2 == 1)
                    return maxLeft;

                int minRight = 0;
                if (i == m)
                    minRight = nums2[j];
                else if (j == n)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums1[i], nums2[j]);
                return (double)(maxLeft + minRight) / 2;
            }
        }
        return 0;
    }
}
