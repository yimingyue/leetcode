package leetcode.FindMissingPositive;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/26/14
 * Time: 8:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A.length == 0)
            return 1;
        int i = 0;
        int n = 0;
        while (i < A.length) {
            if (A[i] > 0)
                n++;
            i++;
        }
        i = 0;
        while (i < A.length) {
            if (A[i] < 1 || A[i] > n)
                i++;
            else if (A[i] == i+1)
                i++;
            else {
                int j = A[i]-1;
                if (A[i] == A[j])
                    i++;
                else {
                    int tmp = A[j];
                    A[j] = A[i];
                    A[i] = tmp;
                }
            }
        }
        i = 0;
        while (i < A.length) {
            if (A[i] != i+1)
                return i+1;
            i++;
        }
        return i+1;
    }
}