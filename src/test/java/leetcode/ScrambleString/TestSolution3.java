package leetcode.ScrambleString;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;

/**
 * Created by ymyue on 1/1/16.
 */
public class TestSolution3 {
    @Test
    public void test0() {
        assertFalse(new Solution3().isScramble("abcd", "adbc"));
    }
}
