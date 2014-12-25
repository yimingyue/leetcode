package Searcha2DMatrix;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/9/14
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestSearcha2DMatrix {
    @Test
    public void test1() {
        Solution s = new Solution();
        int[][] matrix = {{1, 3},{5, 7},{9, 11}};
        int target = 7;
        assertEquals(true, s.searchMatrix(matrix, target));
    }
}
