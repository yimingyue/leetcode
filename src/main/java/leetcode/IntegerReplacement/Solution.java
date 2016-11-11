package leetcode.IntegerReplacement;

/**
 * Created by ymyue on 9/24/16.
 */
public class Solution {
    public int integerReplacement(int n) {
        if ((n & (n-1)) == 0) {
            int count = 0;
            while ((n ^ (1 << count)) != 0)
                count++;
            return count;
        }
        if ((n & 1) == 0)
            return integerReplacement(n>>1) + 1;
        else
            return Math.min(integerReplacement(n>>1)+2, integerReplacement((n>>1)+1)+2);
    }
}
