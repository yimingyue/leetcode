package google.MinSquareOfLeftSpace;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/4/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(11, solution.minSquare(new String[]{"www", "bb", "cc", "fffff"}, 6));
    }
}
