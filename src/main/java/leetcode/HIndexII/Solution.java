package leetcode.HIndexII;

/**
 * Created by ymyue on 6/27/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null)
            throw new IllegalArgumentException();
        int i = citations.length-1;
        int res = 0;
        while (i >= 0) {
            if (citations[i] >= citations.length-i)
                res = citations.length-i;
            i--;
        }
        return res;
    }
}
