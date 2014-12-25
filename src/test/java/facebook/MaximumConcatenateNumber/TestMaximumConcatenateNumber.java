package facebook.MaximumConcatenateNumber;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/24/14
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMaximumConcatenateNumber {
    @Test
    public void test1() {
        Solution s = new Solution();
        int [] nums = {3, 30, 34, 5, 9};
        assertEquals(s.maximumConcatenateNumber(nums), "9534330");
    }
}
