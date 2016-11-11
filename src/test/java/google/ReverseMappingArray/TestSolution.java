package google.ReverseMappingArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/7/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertArrayEquals(new String[]{"dog", "cat", "mouse", "rabbit"}, solution.reverseMapping(new String[]{"cat", "rabbit", "dog", "mouse"}, new int[]{2, 0, 3, 1}));
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new String[]{"dog", "cat", "mouse", "rabbit", "pig", "bird"}, solution.reverseMapping(new String[]{"cat", "rabbit", "dog", "mouse", "bird", "pig"}, new int[]{2, 0, 3, 1, 5, 4}));
    }
}
