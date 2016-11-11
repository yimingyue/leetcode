package leetcode.DivideTwoIntegers;

/**
 * Created by ymyue on 6/26/16.
 * Time complexity: O(logn)
 * Space compexity: O(1)
 */
public class Solution3 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (dividend ==  Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long lDividend = Math.abs((long)dividend);
        long lDivisor = Math.abs((long)divisor);

        int res = 0;
        boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        while (lDividend >= lDivisor) {
            int shift = 0;
            while (lDividend >= (lDivisor << shift))
                shift++;
            lDividend -= lDivisor << (shift-1);
            res += 1 << (shift-1);
        }
        return neg ? -res : res;
    }
}
