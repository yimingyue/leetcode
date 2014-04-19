package RotateSearch;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/15/14
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public boolean search(int[] A, int target) {
        int i = partition(A, 0, A.length-1);
        if (target == A[0])
            return true;
        else if (target > A[0])
            return search(A, 1, i, target);
        else
            return search(A, i+1, A.length-1, target);
    }

    private int partition(int [] A, int start, int end) {
        if (start == end)
            return start;
        if (start == end -1) {
            if (A[start] <= A[end])
                return end;
            else
                return start;
        }
        int mid = (start + end) / 2;
        if (A[mid] > A[start])
            return partition(A, mid, end);
        else if (A[mid] < A[start])
            return partition(A, start, mid-1);
        else {
            while (mid > start) {
                if (A[mid] == A[start])
                    start++;
                else break;
            }
            if (mid == start)
                return partition(A, mid, end);
            if (A[mid] < A[start])
                return partition(A, start, end);
            else
                return partition(A, mid-1, end);
        }
    }

    private boolean search(int [] A, int start, int end, int target) {
        if (start > end)
            return false;
        int mid = (start + end)/2;
        if (A[mid] == target)
            return true;
        else if (A[mid] < target)
            return search(A, mid+1, end, target);
        else
            return search(A, start, mid-1, target);
    }
}