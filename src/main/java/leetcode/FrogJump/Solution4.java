package leetcode.FrogJump;

/**
 * Created by ymyue on 9/22/16.
 * Time limit exceeds
 */
public class Solution4 {
    public boolean canCross(int[] stones) {
        return canCross(stones, 0, 1);
    }

    private boolean canCross(int[] stones, int i, int dist) {
        if (i == stones.length-1)
            return true;
        int j = i+1;
        while (j < stones.length) {
            if (stones[j] - stones[i] == dist)
                if (canCross(stones, j, dist+1) || canCross(stones, j, dist) || canCross(stones, j, dist-1))
                    return true;
            else if (stones[j] - stones[i] > dist)
                    break;
            j++;
        }
        return false;
    }
}
