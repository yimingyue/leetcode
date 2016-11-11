package leetcode.SparseMatrixMultiplication;

import org.junit.Test;

/**
 * Created by ymyue on 6/12/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        int[][] A = {
        { 1, 0, 0},
        {-1, 0, 3}
        };

        int[][] B = {
        { 7, 0, 0 },
        { 0, 0, 0 },
        { 0, 0, 1 }
        };
        System.out.println(solution.multiply(A, B));
    }
}
