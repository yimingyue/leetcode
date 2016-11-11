package google.CountOfEqualDivide;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/4/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(1, solution.countOfEqualDivide(3));
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, solution.countOfEqualDivide(4));
    }

    @Test
    public void test2() {
        Assert.assertEquals(8, solution.countOfEqualDivide(7));
    }
}
