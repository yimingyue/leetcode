package main.java.leetcode.dto;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/9/14
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
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
}
