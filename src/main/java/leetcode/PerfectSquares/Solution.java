package leetcode.PerfectSquares;

/**
 * Created by ymyue on 10/19/16.
 */
public class Solution {
    public int numSquares(int n) {
        int[] squares = new int[n+1];
        squares[0] = 0;
        for (int i = 1; i <= n; i++) {
            squares[i] = i;
            for (int j = 1; j <= i / j; j++) {
                squares[i] = Math.min(squares[i], squares[i-j*j] + 1);
            }
        }
        return squares[n];
    }
}
