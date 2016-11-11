package google.LongestSubstringwithAtMostKDistinctCharacters;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/10/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(11, solution.longestSubString("abcacbadbabadbabca", 3));
    }
}
