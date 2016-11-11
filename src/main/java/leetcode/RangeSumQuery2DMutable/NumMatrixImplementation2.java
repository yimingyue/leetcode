package leetcode.RangeSumQuery2DMutable;

/**
 * Created by ymyue on 10/15/16.
 */
public class NumMatrixImplementation2 implements NumMatrix {
    int[][] tree;
    int[][] num;
    int m;
    int n;
    public NumMatrixImplementation2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.num = new int[m][n];
        this.tree = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    @Override
    public void update(int row, int col, int val) {
        for (int i = row+1; i < m+1; i += i & -i) {
            for (int j = col+1; j < n+1; j += j & -j) {
                tree[i][j] += val - num[row][col];
            }
        }
        num[row][col] = val;
    }

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) + sum(row1-1, col1-1) - sum(row1-1, col2) - sum(row2-1, col2);
    }

    private int sum(int row, int col) {
        int sum = 0;
        for (int i = row+1; i != 0; i -= i & -i) {
            for (int j = col+1; j != 0; j -= j & -j) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
}
