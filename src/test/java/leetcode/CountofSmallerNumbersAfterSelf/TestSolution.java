package leetcode.CountofSmallerNumbersAfterSelf;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/1/16.
 */
public class TestSolution {
    Solution4 solution = new Solution4();
    @Test
    public void test0() {
        Assert.assertArrayEquals(new Integer[]{2, 1, 1, 0}, solution.countSmaller(new int[]{5, 2, 6, 1}).toArray());
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new Integer[] {10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0},
                solution.countSmaller(new int[] {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}).toArray());
    }
}
