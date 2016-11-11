package leetcode.MaximumSizeSubarraySumEqualsk;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 6/12/16.
 */
public class TestSolution {
    Solution solution = new Solution();
    @Test
    public void test0() {
        assertEquals(2, solution.maxSubArrayLen(new int[] {1, 1, 0}, 1));
    }
}
