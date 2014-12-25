package leetcode.EquilibriumIndex;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 5/25/14
 * Time: 8:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 7
        if (A.length == 0)
            return 0;

        int rSum = 0;
        for (int val : A)
            rSum += val;
        rSum -= A[0];
        if (rSum == 0)
            return 0;
        int lSum = 0;

        for (int i = 1; i < A.length; i++) {
            rSum -= A[i];
            lSum += A[i-1];
            if (lSum == rSum)
                return i;
        }
        return -1;
    }
}
