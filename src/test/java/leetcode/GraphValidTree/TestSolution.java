package leetcode.GraphValidTree;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by ymyue on 1/23/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        assertTrue(new Solution().validTree(5,new int[][]{{0, 1},{0,2},{2,3},{2,4}}));
    }

    @Test
    public void test1() {
        assertFalse(new Solution().validTree(4, new int[][]{{0, 1}, {2, 3}}));
    }
}
