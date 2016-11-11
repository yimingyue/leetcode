package leetcode.RussianDollEnvelopes;

import java.util.Arrays;

/**
 * Created by ymyue on 6/28/16.
 * Time complexity: O(NlogN)
 * Space complexity: O(N)
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (x, y) -> x[0] - y[0] == 0 ? y[1] - x[1] : x[0] - y[0]);
        int[] ends = new int[envelopes.length];
        int len = 0;
        for (int i = 0; i < envelopes.length; i++) {
            int low = 0;
            int high = len-1;
            while (low <= high) {
                int mid = low + (high-low)/2;
                if (envelopes[i][1] <= ends[mid]) {
                    high = mid-1;
                } else
                    low = mid+1;
            }
            if (low == len)
                ends[len++] = envelopes[i][1];
            else
                ends[low] = Math.min(ends[low], envelopes[i][1]);
        }
        return len;
    }
}
