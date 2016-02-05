package leetcode.ShortestDistancefromAllBuildings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/8/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        int[][] grid = new int[][] {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        assertEquals(7, new Solution().shortestDistance(grid));
    }
}
