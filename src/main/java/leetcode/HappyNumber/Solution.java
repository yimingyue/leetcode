package leetcode.HappyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 11/1/15.
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<> ();
        while (n != 1) {
            if (!set.add(n))
                return false;
            n = getNextHappy(n);
        }
        return true;
    }

    private int getNextHappy(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n%10)*(n%10);
            n /= 10;
        }
        return sum;
    }
}
