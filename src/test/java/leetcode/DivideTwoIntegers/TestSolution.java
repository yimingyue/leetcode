package leetcode.DivideTwoIntegers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 5/24/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        assertEquals(1, new Solution2().divide(1, 1));
    }

    @Test
    public void test2() {
        assertEquals(2147483647, new Solution2().divide(2147483647, 1));
    }
}
