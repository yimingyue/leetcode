package leetcode.EvaluateDivision;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 9/24/16.
 */
public class TestSolution {
    Solution solution = new Solution();
    @Test
    public void test0() {
        Assert.assertArrayEquals(new double[]{6.0, 0.5, -1.0, 1.0, -1.0}, solution.calcEquation(
                new String[][]{{"a", "b"},{"b", "c"}}, new double[]{2.0, 3.0}, new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}}
        ), 0.0001);
    }
}
