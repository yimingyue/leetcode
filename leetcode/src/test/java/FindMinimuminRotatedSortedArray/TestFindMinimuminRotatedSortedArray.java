package FindMinimuminRotatedSortedArray;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/23/14
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestFindMinimuminRotatedSortedArray {
    @Test
    public void TestAll() {
        Solution s = new Solution();
        int [] array0 = {0};
        int [] array1 = {1, 2};
        int [] array2 = {2, 1};
        assertEquals(s.findMin(array0), 0);
        assertEquals(s.findMin(array1), 1);
        assertEquals(s.findMin(array2), 1);
    }
}
