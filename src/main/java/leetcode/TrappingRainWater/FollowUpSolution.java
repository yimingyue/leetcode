package leetcode.TrappingRainWater;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/25/14
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */

/*
Follow up: if 0 means water will leak, try to solve the problem.
 */
public class FollowUpSolution {
    public int trap(int[] A) {
        int n = A.length;
        if (n < 3)
            return 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = A[0];
        maxRight[n-1] = A[n-1];
        for (int i = 1; i < n; i++) {
            if (A[i] == 0)
                maxLeft[i] = 0;
            else
                maxLeft[i] = Math.max(maxLeft[i-1], A[i]);

        }

        for (int i = n-2; i >= 0; i--) {
            if (A[i] == 0)
                maxRight[i] = 0;
            else
                maxRight[i]= Math.max(maxRight[i+1], A[i]);
        }

        int total = 0;
        for (int i = 1; i < n-1; i++)
            total += Math.min(maxLeft[i], maxRight[i]) - A[i];
        return total;
    }
}
