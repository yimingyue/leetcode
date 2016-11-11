package leetcode.RotateSort;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/7/14
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int search(int[] A, int target) {
        int i = findMid(A, 0, A.length-1);
        if (i == 0)
            return binarySearch(A, 0, A.length-1, target);
        if (target >= A[0])
            return binarySearch(A, 0, i-1, target);
        else
            return binarySearch(A, i, A.length-1, target);
    }
    private int findMid(int [] A, int start, int end) {
        if (start == end)
            return start;
        if (start == end-1)
            return A[start] < A[end] ? start : end;
        if (A[start] < A[end])
            return start;
        int mid = (start+end)/2;
        if (A[start] < A[mid])
            return findMid(A, mid+1, end);
        else
            return findMid(A, start, mid);
    }
    private int binarySearch(int [] A, int start, int end, int value) {
        if (start > end)
            return -1;
        int mid = (start+end)/2;
        if (A[mid] ==  value)
            return mid;
        if (A[mid] < value)
            return binarySearch(A, mid+1, end, value);
        else
            return binarySearch(A, start, mid-1, value);
    }
}