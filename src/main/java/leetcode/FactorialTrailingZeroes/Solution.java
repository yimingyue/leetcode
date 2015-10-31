package leetcode.FactorialTrailingZeroes;

/**
 * Created by ymyue on 10/30/15.
 */
public class Solution {
    public int trailingZeroes(int n) {
        if (n <= 0)
            return 0;
        int count = 0;
        while (n != 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }
}
