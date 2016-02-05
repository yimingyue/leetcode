package leetcode.MedianofTwoSortedArrays;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/9/14
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    /*
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int k = (m+n)/2;
        if ((m + n) % 2 == 0) {
            return ((double)findK(A, B, 0, 0, k-1) + (double)findK(A, B, 0, 0, k))/2;
        } else
            return (double)findK(A, B, 0, 0, k);
    }

    private int findK(int[] A, int[] B, int s1, int s2, int k) {
        int m = A.length - s1;
        int n = B.length - s2;

        if (m  == 0)
            return B[s2+k];
        if (n == 0)
            return A[s1+k];
        if (k == 0)
            return A[s1] < B[s2] ? A[s1] : B[s2];
        int p = (k-1) / 2;
        if (p >= m)
            p = m - 1;
        if (p >= n)
            p = n -1;
        if (A[s1+p] < B[s2+p]) {
            return findK(A, B, s1+p+1, s2, k-p-1);
        } else
            return findK(A, B, s1, s2+p+1, k-p-1);
    }
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0)
            return 0d;
        int i = 0;
        int j = nums1.length;
        int x = 0;
        int y = nums2.length;
        while (true) {
            int m = j - i;
            int n = y - x;
            if (m == 1 && n == 1) {
                return ((double)(nums1[i] + nums2[x])) / 2;
            }
            if (m < n) {    // swap
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
                int v = i;
                i = x;
                x = v;
                v = j;
                j = y;
                y = v;
                v = m;
                m = n;
                n = v;
            }
            if (n == 0) {
                if (m % 2 == 0) {
                    return ((double)nums1[i+m/2-1] + (double)nums1[i+m/2]) / 2;
                } else
                    return (double)nums1[i+m/2];
            }
            else if (n == 1) {
                int k = i + m/2;
                if ((m + n) % 2 == 0) {
                    if (nums2[x] < nums1[k-1]) {
                        return ((double)(nums1[k-1]+nums1[k])) / 2;
                    } else if (nums2[x] < nums1[k+1]) {
                        return ((double)(nums2[x]+nums1[k])) / 2;
                    } else {
                        return ((double)(nums1[k]+nums1[k+1])) / 2;
                    }
                } else {
                    if (nums2[x] < nums1[k-1]) {
                        return (double)nums1[k-1];
                    } else if (nums2[x] < nums1[k]) {
                        return (double)nums2[x];
                    } else {
                        return (double)nums1[k];
                    }
                }
            }
            int k = n / 2;
            if (nums1[i+k-1] < nums2[x+k-1]) {
                i += k;
            } else {
                x += k;
            }
            if (nums1[j-k] < nums2[y-k]) {
                y -= k;
            } else{
                j -= k;
            }
        }
    }
}
