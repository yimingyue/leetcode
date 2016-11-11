package leetcode.ShuffleanArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 9/18/16.
 */
public class TestSolution {

    @Test
    public void test0() {
        Solution solution = new Solution(new int[]{1, 2, 3});
        solution.shuffle();
        Assert.assertArrayEquals(new int[] {1, 2, 3} ,solution.reset());
        solution.shuffle();
    }

}
