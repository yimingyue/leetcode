package leetcode.MergeSortedArray;

/**
 * Created by ymyue on 6/21/16.
 * Time complexity: O(m+n)
 * Space complexity: O(1)
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while (k >= 0) {
            if (i < 0)
                nums1[k--] = nums2[j--];
            else if (j < 0)
                nums1[k--] = nums1[i--];
            else if (nums1[i] < nums2[j])
                nums1[k--] = nums2[j--];
            else
                nums1[k--] = nums1[i--];
        }
    }
}
