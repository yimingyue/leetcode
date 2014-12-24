package SearchinRotatedSortedArray;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/8/14
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int search(int[] A, int target) {
        return search(A, 0, A.length-1, target);
    }

    private int search(int[] A, int start, int end, int target) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (A[start] < A[end]) {
            if (A[mid] == target)
                return mid;
            if (A[mid] < target)
                return search(A, mid+1, end, target);
            if (A[mid] > target)
                return search(A, start, mid-1, target);
        } else {
            if (A[mid] == target)
                return mid;
            if (A[start] <= A[mid]) {
                if (target >= A[start] && target < A[mid])
                    return search(A, start, mid-1, target);
                else
                    return search(A, mid+1, end, target);
            } else {
                if (target > A[mid] && target <= A[end])
                    return search(A, mid+1, end, target);
                else
                    return search(A, start, mid-1, target);
            }
        }
        return -1;
    }
}
