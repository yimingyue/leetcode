package leetcode.KthLargestElementinanArray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/24/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        assertEquals(1, new Solution().findKthLargest(new int[]{2, 1}, 2));
    }

    @Test
    public void test1() {
        assertEquals(-1, new Solution().findKthLargest(new int[]{-1, 2, 0}, 3));
    }
}
