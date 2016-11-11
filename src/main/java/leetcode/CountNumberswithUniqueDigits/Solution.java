package leetcode.CountNumberswithUniqueDigits;

/**
 * Created by ymyue on 7/18/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int count = 1;
        int i = 1;
        while (i <= n) {
            int c = 9;
            for (int k = 1; k < i; k++)
                c *= (10 - k);
            count += c;
            i++;
        }
        return count;
    }
}
