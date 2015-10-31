package leetcode.InterleavingString;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by ymyue on 8/23/15.
 */
public class TestInterleavingString {
    @Test
    public void test1() {
        assertTrue(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    @Test
    public void test2() {
        assertFalse(new Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
