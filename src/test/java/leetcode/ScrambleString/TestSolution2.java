package leetcode.ScrambleString;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ymyue on 7/19/15.
 */
public class TestSolution2 {
    @Test
    public void test1() {
        assertTrue(new Solution2().isScramble("great", "rgaet"));
    }
}
