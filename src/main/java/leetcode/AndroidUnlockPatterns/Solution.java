package leetcode.AndroidUnlockPatterns;

/**
 * Created by ymyue on 10/4/16.
 */
public class Solution {
    public int numberOfPatterns(int m, int n) {
        boolean[] b = new boolean[9];
        return helper(b, 1, 0, m, n) * 4 + helper(b, 1, 1, m, n) * 4 + helper(b, 1, 4, m, n);
    }

    private int helper(boolean[] b, int len, int pos, int m, int n) {
        int count = 0;
        b[pos] = true;
        if (len >= m)
            count++;
        if (len < n) {
            for (int i = 0; i < 9; i++) {
                if (!b[i]) {
                    int x0 = pos / 3;
                    int y0 = pos % 3;
                    int x1 = i / 3;
                    int y1 = i % 3;
                    if ((x1-x0) % 2 == 0 && (y1-y0) % 2 == 0) {
                        int x = (x0+x1) / 2;
                        int y = (y0+y1) / 2;
                        int mid = x * 3 + y;
                        if (!b[mid])
                            continue;
                    }
                    count += helper(b, len+1, i, m, n);
                }
            }
        }
        b[pos] = false;
        return count;
    }
}
