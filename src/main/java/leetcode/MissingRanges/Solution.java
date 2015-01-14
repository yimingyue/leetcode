package leetcode.MissingRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 1/7/15
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        int prev = lower -1;
        for (int i = 0; i <= A.length; i++) {
            int cur = (i == A.length) ? upper+1 : A[i];
            if (cur - prev >= 2) {
                ranges.add(getRange(prev+1, cur-1));
            }
            prev = cur;
        }
        return ranges;
    }
    private String getRange(int from, int to) {
        return (from == to) ? String.valueOf(from) : from + "->" + to;
    }
}
