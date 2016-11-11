package leetcode.QueueReconstructionbyHeight;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 9/24/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();

    @Test
    public void test0() {
        int[][] result = solution.reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
        int[][] expect = new int[][] {{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}};
        for (int i = 0; i < result.length; i++)
            Assert.assertArrayEquals(result[i], expect[i]);
    }
}
