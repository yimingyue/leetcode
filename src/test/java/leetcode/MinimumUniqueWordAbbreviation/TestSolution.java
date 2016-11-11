package leetcode.MinimumUniqueWordAbbreviation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/8/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();

    @Test
    public void test0() {
        Assert.assertEquals("a4", solution.minAbbreviation("apple", new String[]{"blade"}));
    }
}
