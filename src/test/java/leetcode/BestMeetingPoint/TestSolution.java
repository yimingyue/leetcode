package leetcode.BestMeetingPoint;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 6/5/16.
 */
public class TestSolution {
    Solution4 solution = new Solution4();
//    SolutionDPnBackTracking solution = new SolutionDPnBackTracking();
    @Test
    public void test0() {
        int[][] grid = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,1,0},{1,1,0,0,0,0,1,0,0},{0,0,0,1,1,1,0,0,0}};
        assertEquals(19, solution.minTotalDistance(grid));
    }

    @Test
    public void test1() {
        int[][] grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        assertEquals(6, solution.minTotalDistance(grid));
    }
}
