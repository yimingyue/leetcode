package leetcode.NumberofDigitOne;

/**
 * Created by ymyue on 1/18/16.
 */
public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;
        int count = 0;
        long base = 1;
        while (n >= base) {
            count += n / (base*10) * base;
            long m = n % (base * 10);
            if (m >= (2*base-1))
                count += base;
            else if (m >= base)
                count += (m - base + 1);
            base *=10;
        }
        return count;
    }
}
