package FindTopKSum;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/14/14
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestFindTopKSum {
    @Test
    public void test1() {
        int[] A = {10, 9, 5, 4, 3, 2};
        int[] B = {12, 11, 9, 6, 1, 0};
        Solution s = new Solution();
        List<Integer> list = s.findTopKSum(A, B, 10);
        for (int i = 0; i < list.size()-1; i++)
            assertEquals(true, list.get(i) < list.get(i+1));
    }
}
