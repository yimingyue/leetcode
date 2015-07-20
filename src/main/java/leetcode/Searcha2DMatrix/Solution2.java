package leetcode.Searcha2DMatrix;

/**
 * Created by ymyue on 6/21/15.
 */
public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = searchRow(matrix, target, 0, matrix.length-1);
        return searchCol(matrix, target, row, 0, matrix[0].length-1);
    }

    private int searchRow(int[][] matrix, int target, int start, int end) {
        if (start > end)
            return end;
        int mid = (start + end) / 2;
        if (target == matrix[mid][0])
            return mid;
        else if (target > matrix[mid][0])
            return searchRow(matrix, target, mid+1, end);
        else
            return searchRow(matrix, target, start, mid-1);
    }

    private boolean searchCol(int[][] matrix, int target, int row, int start, int end) {
        if (row < 0 || row >= matrix.length)
            return false;
        if (start > end)
            return false;
        if (start == end)
            return matrix[row][start] == target;
        int mid = (start + end) / 2;
        if (matrix[row][mid] == target)
            return true;
        if (matrix[row][mid] < target)
            return searchCol(matrix, target, row, mid+1, end);
        return searchCol(matrix, target, row, start, mid-1);
    }
}
