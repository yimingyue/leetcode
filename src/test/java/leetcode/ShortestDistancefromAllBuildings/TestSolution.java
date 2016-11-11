package leetcode.ShortestDistancefromAllBuildings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/8/16.
 */
public class TestSolution {
    Solution3 solution = new Solution3();
    @Test
    public void test0() {
        int[][] grid = new int[][] {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        assertEquals(7, solution.shortestDistance(grid));
    }

    @Test
    public void test1() {
        int[][] grid = new int[][] {
                {1}
        };
        assertEquals(-1, solution.shortestDistance(grid));
    }
}
