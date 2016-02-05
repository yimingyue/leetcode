package leetcode.ReverseInteger;

/**
 * Created by ymyue on 11/22/15.
 */
public class Solution2 {
    public int reverse(int x) {
        int base = 0;
        if (x < 0) {
            while (x < 0) {
                if (base < Integer.MIN_VALUE / 10)
                    return 0;
                base *= 10;
                int y = x % 10;
                if (Integer.MIN_VALUE - base > y)
                    return 0;
                base += y;
                x /= 10;
            }
        } else if (x > 0) {
            while (x > 0) {
                if (base > Integer.MAX_VALUE / 10)
                    return 0;
                base *= 10;
                if (Integer.MAX_VALUE - base < x % 10)
                    return 0;
                base += x % 10;
                x /= 10;
            }
        }
        return base;
    }
}
