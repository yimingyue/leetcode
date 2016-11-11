package leetcode.FrogJump;

import java.util.Arrays;

/**
 * Created by ymyue on 9/22/16.
 * // This doesn't work
 * // example {0,1,3,6,10,13,15,16,19,21,25}
 * // the distance on 21 is 6 or 2. Leaving the 4 in the gap
 */
public class Solution3 {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (n <= 1)
            return true;
        int[] min = new int[n];
        int[] max = new int[n];
        Arrays.fill(min, stones.length);

        min[0] = 1;
        max[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int dist = stones[i] - stones[j];
                if (dist <= max[j] && dist >= min[j]) {
                    max[i] = Math.max(max[i], dist+1);
                    min[i] = Math.min(min[i], dist - 1);
                    if (max[i] + stones[i] >= stones[stones.length-1] && min[i] + stones[i] <= stones[stones.length-1])
                        return true;
                }
            }
        }
        return false;
    }
}
