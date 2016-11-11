package leetcode.LexicographicalNumbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 9/18/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertArrayEquals(new int[] {1,10,11,12,13,2,3,4,5,6,7,8,9}, solution.lexicalOrder(13).stream().mapToInt(i -> (int)i).toArray());
    }
}
