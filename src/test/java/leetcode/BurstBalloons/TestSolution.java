package leetcode.BurstBalloons;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/18/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(167, solution.maxCoins(new int[]{3, 1, 5, 8}));
    }

    @Test
    public void test1() {
        int n = 500;
        for (int k = 1; k < 500; k++) {
            long product = n;
            for (int i = 1; i < k; i++) {
                product *= (n - i);
                product /= i+1;
            }
            System.out.println(product);
        }
    }


}
