package leetcode.RestoreIPAddresses;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/1/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        List<String> list = new Solution2().restoreIpAddresses("1111");
        assertEquals(1, list.size());
    }

    @Test
    public void test1() {
        List<String> list = new Solution2().restoreIpAddresses("1011");
        assertEquals(1, list.size());
    }

    @Test
    public void test2() {
        List<String> list = new Solution2().restoreIpAddresses("2552550255");
        assertEquals(2, list.size());
    }

    @Test
    public void test3() {
        List<String> list = new Solution2().restoreIpAddresses("255550255");
        assertEquals(3, list.size());
    }
}
