package leetcode.CompareVersionNumbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 10/25/15.
 */
public class TestSolution2 {
    @Test
    public void test0() {
        Solution2 solution2 = new Solution2();
        String version1 = "1";
        String version2 = "0";
        assertEquals(1, solution2.compareVersion(version1, version2));
    }

    @Test
    public void test2() {
        Solution2 solution2 = new Solution2();
        String version1 = "1.0";
        String version2 = "1";
        assertEquals(0, solution2.compareVersion(version1, version2));
    }
}
