package leetcode.LargestNumber;

import leetcode.java8.LargestNumber.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 5/28/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        int[] nums = {0, 0};
        assertEquals("0", solution.largestNumer(nums));
    }
}
