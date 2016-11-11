package leetcode.PowerofTwo;

/**
 * Created by ymyue on 7/9/16.
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        while (n != 1) {
            if ((n & 1) == 1)
                return false;
            n >>= 1;
        }
        return true;
    }
}
