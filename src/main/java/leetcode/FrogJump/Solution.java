package leetcode.FrogJump;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 9/17/16.
 */
public class Solution {
    class Jump {
        int units;
        int stone;
        public Jump(int units, int stone) {
            this.units = units;
            this.stone = stone;
        }
    }
    public boolean canCross(int[] stones) {
        Set[] jumps = new Set[stones.length];
        jumps[0] = new HashSet<Integer> ();
        jumps[0].add(0);
        for (int i = 1; i < stones.length; i++) {
            jumps[i] = new HashSet<> ();
            for (int j = 0; j < i; j++) {
                int dist = stones[i] - stones[j];
                if (jumps[j].contains(dist) || jumps[j].contains(dist+1) || jumps[j].contains(dist-1))
                    jumps[i].add(dist);
            }
        }
        return jumps[jumps.length-1].size() > 0;
    }
}
