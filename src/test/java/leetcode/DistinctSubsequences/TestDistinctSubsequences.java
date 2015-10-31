package leetcode.DistinctSubsequences;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 10/10/15.
 */
public class TestDistinctSubsequences {
    @Test
    public void test0() {
        Solution solution = new Solution();
        assertEquals(4, solution.numDistinct("aabb", "ab"));
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        assertEquals(3, solution.numDistinct("ccc", "c"));
    }
}
