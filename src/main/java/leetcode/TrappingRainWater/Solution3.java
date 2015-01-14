package leetcode.TrappingRainWater;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/25/14
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution3 {
    public int trap(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = A[0];
        right[A.length-1] = A[A.length-1];
        for (int i = 1; i < A.length; i++)
            left[i] = Math.max(left[i-1], A[i]);
        for (int i = A.length-2; i >= 0; i--)
            right[i] = Math.max(right[i+1], A[i]);

        int total = 0;
        for (int i = 1; i < A.length-1; i++)
            total += Math.min(left[i], right[i]) - A[i];
        return total;
    }
}
