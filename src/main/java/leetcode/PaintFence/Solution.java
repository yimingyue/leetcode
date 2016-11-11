package leetcode.PaintFence;

/**
 * Created by ymyue on 10/22/16.
 */
public class Solution {
    public int numWays(int n, int k) {
        if (n == 0)
            return 0;
        if (n == 1)
            return k;
        int same = k;
        int diff = k * (k-1);

        for (int i = 3; i <= n; i++) {
            int tmp = diff;
            diff = (diff+same) * (k-1);
            same = tmp;
        }
        return same + diff;
    }
}
