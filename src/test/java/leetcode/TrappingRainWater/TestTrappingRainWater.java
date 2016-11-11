package leetcode.TrappingRainWater;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/25/14
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestTrappingRainWater {
    @Test
    public void test1() {
        Solution2 solution = new Solution2();
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(6, solution.trap(A));
    }

    @Test
    public void testFollowUp1() {
        FollowUpSolution solution = new FollowUpSolution();
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(1, solution.trap(A));
    }

    @Test
    public void testFollowUp2() {
        FollowUpSolution solution = new FollowUpSolution();
        int[] A = {0,1,0,2,1,1,1,3,2,1,2,1};
        assertEquals(4, solution.trap(A));
    }

    @Test
    public void test2() {
        Solution5 solution = new Solution5();
        int[] A = {0,1,0,2,1,1,1,3,2,1,2,1};
        assertEquals(5, solution.trap(A));
    }
}
