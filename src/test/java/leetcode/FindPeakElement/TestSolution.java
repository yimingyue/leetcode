package leetcode.FindPeakElement;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 6/24/16.
 */
public class TestSolution {
//    SolutionTrie solution = new SolutionTrie();

    Solution20160804 solution = new Solution20160804();
    @Test
    public void test0() {
        assertEquals(0, solution.findPeakElement(new int[]{-31,-59,-94,13,-44,54,83,-68,40,72,0,29,-16,88,27,-23,59,11,15,37,-11,-2,-37,-21,-81,-32,-46,93,-98,75,24,1,70,-49,-15,-57,-79,-41,64,-52,97,-92,63,3,-42,-10,-6,18,-71,21}));
    }

    @Test
    public void test1() {
        assertEquals(2, solution.findPeakElement(new int[] {1, 2, 3, 1}));
    }

    @Test
    public void test2() {
        assertEquals(-1, solution.findPeakElement(new int[] {1, 1, 1}));
    }

    @Test
    public void test3() {
        assertEquals(-1, solution.findPeakElement(new int[] {1, 2, 2}));
    }

    @Test
    public void test4() {
        assertEquals(2, solution.findPeakElement(new int[] {1, 2, 3}));
    }

    @Test
    public void test5() {
        assertEquals(1, solution.findPeakElement(new int[] {1, 3, 2, 3, 3, 3}));
    }
}
