package leetcode.Searcha2DMatrix;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ymyue on 6/21/15.
 */
public class TestSearcha2DMatrix2 {
    @Test
    public void test1() {
        Solution2 solution2 = new Solution2();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        assertTrue(solution2.searchMatrix(matrix, 11));
    }
}
