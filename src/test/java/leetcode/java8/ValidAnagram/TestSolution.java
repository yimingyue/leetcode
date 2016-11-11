package leetcode.java8.ValidAnagram;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by ymyue on 5/31/16.
 */
public class TestSolution {
//    Radix s = new Radix();
//    SolutionDeque s = new SolutionDeque();
    Solution3 s = new Solution3();
    @Test
    public void test0() {
        assertFalse(s.isAnagram("aacc", "ccac"));
    }
}
