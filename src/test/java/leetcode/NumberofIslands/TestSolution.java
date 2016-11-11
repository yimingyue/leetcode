package leetcode.NumberofIslands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/7/16.
 */
public class TestSolution {

//    SolutionDeque solution = new SolutionDeque();
    Solution3 solution = new Solution3();
    @Test
    public void test0() {
        char[][] grid = new char[][] {{'1', '0', '1', '1', '0', '1', '1'}};
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void test1() {
        String[] strs = new String[] {"11110","11010","11000","00000"};
        char[][] grid = new char[4][];
        for (int i = 0; i < grid.length; i++)
            grid[i] = strs[i].toCharArray();
        assertEquals(1, solution.numIslands(grid));
    }
}
