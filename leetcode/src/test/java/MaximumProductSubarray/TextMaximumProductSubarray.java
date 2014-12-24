package MaximumProductSubarray;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/23/14
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class TextMaximumProductSubarray {
    @Test
    public void TestAll() {
        Solution s = new Solution();

        int [] array0 = {2,3,-2,4};
        assertEquals(s.maxProduct(array0), 6);
        int [] array1 = {-1, 0};
        assertEquals(s.maxProduct(array1), 0);
        int [] array2 = {1, 0, 2, -3, 3, -5, 1};
        assertEquals(s.maxProduct(array2), 90);
        int [] array3 = {-5, 2, 4, -2, -3, 0, -2, 1, -1, 2};
        assertEquals(s.maxProduct(array3), 80);
        int [] array4 = {2, 4, -3, 5};
        assertEquals(s.maxProduct(array4), 8);
        int [] array5 = {0, 2};
        assertEquals(s.maxProduct(array5), 2);
    }
}
