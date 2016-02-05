package leetcode.NumberofIslands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/7/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        char[][] grid = new char[][] {{'1', '0', '1', '1', '0', '1', '1'}};
        assertEquals(3, new Solution().numIslands(grid));
    }
}
