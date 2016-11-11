package leetcode.SentenceScreenFitting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/8/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(5000, solution.wordsTyping(new String[]{"h"}, 100, 100));
    }
}
