package google.CountOfAppearanceInIntervals;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/4/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertArrayEquals(new int[] {0, 1, 2, 2, 1}, solution.countOfAppearanceInIntervals(new int[][]{
                {1, 3}, {2, 4}
        }, 5));
    }
}
