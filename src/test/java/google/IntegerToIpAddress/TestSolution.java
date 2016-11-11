package google.IntegerToIpAddress;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/5/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals("0.0.0.128", solution.getIpAddress(128));
    }

    public void test1() {
        Assert.assertEquals("127.255.255.255", solution.getIpAddress(Integer.MAX_VALUE));
    }

    public void test2() {
        Assert.assertEquals("0.0.1.0", solution.getIpAddress(256));
    }
}
