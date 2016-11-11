package google.MaxCoinsFromList;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/2/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        System.out.println("88844153".hashCode()%1000+ 1000);
        Assert.assertEquals(19, solution.maxValue(new int[]{7, 3, 5, 8, 9}));
    }
}
