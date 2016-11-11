package leetcode.RotateFunction;

/**
 * Created by ymyue on 9/17/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int f = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            f += i * A[i];
        }

        int max = f;
        for (int i = 0; i < A.length-1; i++) {
            f = f + A.length * A[i] - sum;
            max = Math.max(max, f);
        }
        return max;
    }
}
