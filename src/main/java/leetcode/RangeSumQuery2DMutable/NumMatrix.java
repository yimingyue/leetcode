package leetcode.RangeSumQuery2DMutable;

/**
 * Created by ymyue on 10/15/16.
 */
public interface NumMatrix {

    public void update(int row, int col, int val);

    public int sumRegion(int row1, int col1, int row2, int col2);
}
