package threesum;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/8/14
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestThreeSum {
    @Test
    public void test1() {
        int[] arr = {-1, 1, 0};
        Solution2 solution2 = new Solution2();
        solution2.threeSum(arr);
    }

    @Test
    public void test2() {
        int[] arr = {-2,0,1,1,2};
        Solution2 solution2 = new Solution2();
        solution2.threeSum(arr);
    }
}
