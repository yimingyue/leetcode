package leetcode.NthDigit;

/**
 * Created by ymyue on 9/17/16.
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class Solution {
    public int findNthDigit(int n) {
        int base = 1;
        int digits = 1;
        while (Integer.MAX_VALUE / base >= 9 * digits && n > base * 9 * digits) {
            n -= base * 9 * digits;
            base *= 10;
            digits++;
        }
        int val = base + n / digits;
        if (n % digits == 0)
            return (val - 1) % 10;
        else {
            int count = digits - (n % digits);
            while (count-- > 0)
                val /= 10;
            return val % 10;
        }
    }
}
