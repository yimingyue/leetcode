package PacificAtalantic;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/10/14
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestPacificAtalantic {
    @Test
    public void test1() {
        int[][] a = {{1, 2},{2, 1}};
        Solution s = new Solution();
        List<List<Integer>> list = s.findPoints(a);
        assertEquals(2, list.size());
    }

    @Test
    public void test2() {
        int[][] a = {{1, 2, 2}, {1, 2, 1}, {2, 1, 1}};
        Solution s = new Solution();
        List<List<Integer>> list = s.findPoints(a);
        assertEquals(4, list.size());
    }

    @Test
    public void test3() {
        int[][] a = {{1, 2, 1}, {1, 2, 1}, {2, 1, 1}};
        Solution s = new Solution();
        List<List<Integer>> list = s.findPoints(a);
        assertEquals(7, list.size());
    }

    @Test
    public void test4() {
        int[][] a = {{1, 0, 3, 1, 1}, {2, 3, 2, 6, 7}, {3, 2, 5, 2, 3}, {4, 5, 2, 2, 4}, {4, 6, 7, 1, 5}};
        Solution s = new Solution();
        List<List<Integer>> list = s.findPoints(a);
        assertEquals(7, list.size());
    }
}
