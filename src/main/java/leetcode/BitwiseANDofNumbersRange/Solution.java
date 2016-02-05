package leetcode.BitwiseANDofNumbersRange;

/**
 * Created by ymyue on 11/1/15.
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int base = 1;
        int num = 0;
        int x = 0, y = 0, r = 0;
        for (int i = 0; i < 32; i++) {
            if (i == 31) {
                r = 0;
                x = m - 1;
                y = n;
            } else {
                r = (n - m + 1) / (2 * base) * base;
                x = (m-1) % (2 * base);
                y = n % (2 * base);
            }
            r -= x >= base ? x - base + 1 : 0;
            r += y >= base ? y - base + 1 : 0;
            num += (r % 2) * base;
            base *= 2;
        }
        return num;
    }
}
