package leetcode.TrappingRainWater;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/25/14
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution4 {
    public int trap(int[] A) {
        if (A.length < 3)
            return 0;
        int maxLeft = A[0];
        int maxRight = A[A.length-1];
        int left = 0;
        int right = A.length-1;

        int total = 0;
        while (left <= right) {
            if (A[left] < A[right]) {
                total += Math.max(0, maxLeft - A[left]);
                maxLeft = Math.max(maxLeft, A[left]);
                left++;
            } else {
                total += Math.max(0, maxRight - A[right]);
                maxRight = Math.max(maxRight, A[right]);
                right--;
            }
        }
        return total;
    }
}
