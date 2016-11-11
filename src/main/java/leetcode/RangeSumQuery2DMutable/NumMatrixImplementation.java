package leetcode.RangeSumQuery2DMutable;

/**
 * Created by ymyue on 10/2/16.
 */
public class NumMatrixImplementation {
    int[][] rowSum;
    int m;
    int n;
    public NumMatrixImplementation(int[][] matrix) {
        m = matrix.length;
        n = 0;
        if (m == 0)
            n = 0;
        else
            n = matrix[0].length;
        rowSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
                rowSum[i][j] = sum;
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - (col == 0 ? rowSum[row][col] : rowSum[row][col] - rowSum[row][col-1]);
        for (int j = col; j < n; j++)
            rowSum[row][j] += diff;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += rowSum[i][col2] - (col1 == 0 ? 0 : rowSum[i][col1-1]);
        }
        return sum;
    }
}
