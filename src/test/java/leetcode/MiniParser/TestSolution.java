package leetcode.MiniParser;

import org.junit.Test;

/**
 * Created by ymyue on 9/18/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        solution.deserialize("[123,[456,[789]]]");
    }

    @Test
    public void test1() {
        solution.deserialize("[]");
    }
}
