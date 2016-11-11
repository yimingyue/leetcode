package leetcode.LongestAbsoluteFilePath;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 9/18/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();

    @Test
    public void test0() {
        Assert.assertEquals(20, solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
