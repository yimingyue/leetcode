package leetcode.RangeSumQuery2DMutable;

import org.junit.Test;

/**
 * Created by ymyue on 10/15/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        NumMatrixImplementation2 numMatrix = new NumMatrixImplementation2(new int[][]{
                {3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}
        });
        numMatrix.sumRegion(2,1,4,3);
        numMatrix.update(3,2,2);
        numMatrix.sumRegion(2,1,4,3);
    }
}
