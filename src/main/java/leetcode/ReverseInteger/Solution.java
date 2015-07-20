package leetcode.ReverseInteger;

/**
 * Created by ymyue on 5/17/15.
 */
public class Solution {
    public int reverse(int x) {
        if (x == 0)
            return x;
        boolean positive = x > 0;
        long l = Math.abs((long)x);
        long r = reverse(l);
        if (positive) {
            if (r > (long)Integer.MAX_VALUE)
                return 0;
            else
                return (int)r;
        } else {
            r = r * -1;
            if (r < (long)Integer.MIN_VALUE)
                return 0;
            else
                return (int)r;
        }
    }

    long reverse(long x) {
        long r = 0;
        while (x != 0) {
            r *= 10;
            r += x % 10;
            x /= 10;
        }
        return r;
    }
}
