package leetcode.PermutationSequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 12/24/15.
 */
public class TestSolution2 {
    @Test
    public void test0() {
        Solution2 solution2 = new Solution2();
        assertEquals("231", solution2.getPermutation(3, 4));
    }

    @Test
    public void test1() {
        Solution2 solution2 = new Solution2();
        assertEquals("123", solution2.getPermutation(3, 1));
    }
}
