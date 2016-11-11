package leetcode.RangeAddition;

/**
 * Created by ymyue on 7/17/16.
 * Modified: 09/19/2016
 * Time complexity: O(k+n) - k is number of updates, n is length
 */
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int[] update : updates) {
            result[update[0]] += update[2];
            if (update[1]+1 < length)
                result[update[1]+1] -= update[2];
        }
        for (int i = 0; i < length; i++)
            result[i] += i == 0 ? 0 : result[i-1];
        return result;
    }
}
