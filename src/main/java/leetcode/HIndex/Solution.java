package leetcode.HIndex;

import java.util.Arrays;

/**
 * Created by ymyue on 6/4/16.
 * Using sort
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int i = citations.length-1;
        int h = 0;
        while (i >= 0) {
            if (citations[i] >= citations.length - i)
                h = Math.max(h, citations.length - i);
            else
                break;
            i--;
        }
        return h;
    }
}
