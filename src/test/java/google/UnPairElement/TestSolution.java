package google.UnPairElement;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/15/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(7, solution.unpairedElement(new int[]{1, 1, 7, 8, 8}));
    }
}
