package leetcode.MaximalRectangle;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ymyue on 7/19/15.
 */
public class TestSolution {

    @Test
    public void test1() {
        char[][] matrix = {{'0','1'}, {'0','1'}, {'0','1'},{'1','1'},{'1','1'}};
        assertEquals(5, new Solution().maximalRectangle(matrix));
    }

    @Test
    public void test2() {
        char[][] matrix = {{'0','1'}, {'0','1'}, {'0','1'},{'1','1'},{'1','1'},{'1','1'},{'1','1'}};
        assertEquals(8, new Solution().maximalRectangle(matrix));
    }
}
