package JumpGameII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/23/14
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int jump(int[] A) {
        if (A.length == 0 || A.length == 1)
            return 0;
        int max = -1;
        int step = 0;
        int nMax = 0;
        while (max < nMax) {
            int fMax = nMax;
            step++;
            for (int j = max+1; j <= nMax; j++) {
                int offset = A[j];
                if (offset+j >= A.length-1)
                    return step;
                if (offset + j > fMax)
                    fMax = offset +j;
            }
            max = nMax;
            nMax = fMax;
        }
        return Integer.MAX_VALUE;
    }
}
