package JumpGame;

/**
 * Created by ymyue on 4/20/14.
 */
public class Solution {
    public boolean canJump(int[] A) {
        int m = A.length;
        if (m == 0)
            return true;
        boolean [] b = new boolean [m];
        b[0] = true;
        for (int i = 1; i < m; i++)
            b[i] = false;
        for (int i = 0; i < m; i++) {
            if (!b[i])
                continue;
            for (int j = 1; i + j < m && j <= A[i]; j++) {
                b[i+j] = true;
            }
        }
        return b[m-1];
    }
}
