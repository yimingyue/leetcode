package leetcode.HappyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 11/1/15.
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            if (n == 1)
                return true;
            if (set.contains(sum))
                return false;
            set.add(n);
        }
    }
}
