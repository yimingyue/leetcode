package leetcode.MissingRanges;

import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 1/7/15
 * Time: 5:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMissingRanges {
    @Test
    public void test0() {
        Solution s = new Solution();
        int[] A = {0, 24, 33, 68, 90};
        List<String> list = s.findMissingRanges(A, 10, 99);
        for (String str : list)
            System.out.println(str);
    }
}
