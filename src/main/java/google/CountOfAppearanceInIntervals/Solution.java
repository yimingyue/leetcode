package google.CountOfAppearanceInIntervals;

/**
 * Created by ymyue on 10/4/16.
 * Time complexity: O(n)
 * Range Addition
 */
public class Solution {
    public int[] countOfAppearanceInIntervals(int[][] intervals, int n) {
        int[] result = new int[n];
        for (int[] interval : intervals) {
            result[interval[0]]++;
            if (interval[1]+1 < n)
                result[interval[1]+1]--;
        }
        for (int i = 1; i < n; i++)
            result[i] += result[i-1];
        return result;
    }
}
