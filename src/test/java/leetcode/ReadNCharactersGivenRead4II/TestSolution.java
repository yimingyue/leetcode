package leetcode.ReadNCharactersGivenRead4II;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/31/16.
 */
public class TestSolution {

    @Test
    public void test0() {
        Solution2 solution = new Solution2("ab");
        char[] buf = new char[2];
        Assert.assertEquals(1, solution.read(buf, 1));
        Assert.assertEquals(1, solution.read(buf, 2));
    }
}
