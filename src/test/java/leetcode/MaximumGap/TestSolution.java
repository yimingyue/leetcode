package leetcode.MaximumGap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/18/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        int[] nums = new int[] {1, 2, 4, 7, 9};
        assertEquals(3, new Solution().maximumGap(nums));
    }

    @Test
    public void test1() {
        int[] nums = new int[] {3, 1, 2, 4, 5};
        assertEquals(1, new Solution().maximumGap(nums));
    }
}
