import CountOne.Solution;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/13/14
 * Time: 9:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestCountOne {

    @Test
    public void test1() {
        Solution s = new Solution();
        int num = 3;
        assertEquals(2, s.countOnes(num));
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        int num = 5;
        assertEquals(2, s.countOnes(num));
    }
}
