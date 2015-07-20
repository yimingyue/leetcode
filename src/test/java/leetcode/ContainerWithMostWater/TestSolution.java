package leetcode.ContainerWithMostWater;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ymyue on 6/7/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        assertEquals(1, (new Solution().maxArea(new int[] {1, 2})));
    }

    @Test
    public void test2() {
        assertEquals(1, (new Solution().maxArea(new int[] {2, 1})));
    }

    @Test
    public void test3() {
        assertEquals(55, (new Solution().maxArea(new int[] {4,4,2,11,0,11,5,11,13,8})));
    }

    @Test
    public void test4() {
        assertEquals(4, (new Solution().maxArea(new int[] {1, 2, 4, 3})));
    }
}
