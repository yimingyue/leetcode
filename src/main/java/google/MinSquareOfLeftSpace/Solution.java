package google.MinSquareOfLeftSpace;

/**
 * Created by ymyue on 10/4/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=194262&highlight=google
 * Question 2 - DP solution
 * Time complexity: O(n^2)
 */
public class Solution {
    public int minSquare(String[] strs, int length) {
        int[] mins = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            int len = length - strs[i].length();
            int min = len * len + (i == 0 ? 0 : mins[i-1]);
            int j = i-1;
            while (j >= 0) {
                if ((len = len -1 - strs[j].length()) < 0)
                    break;
                min = Math.min(min, len * len + (j > 0 ? mins[j-1] : 0));
            }
            mins[i] = min;
        }
        return mins[strs.length-1];
    }
}
