package leetcode.LongestIncreasingSubsequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 6/27/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();
    @Test
    public void test0() {
        assertEquals(6, solution.lengthOfLIS(new int[] {3,5,6,2,5,4,19,5,6,7,12}));
    }
}
