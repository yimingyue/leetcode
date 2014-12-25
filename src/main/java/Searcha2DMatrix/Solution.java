package Searcha2DMatrix;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/9/14
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int r = searchRow(matrix, target, 0, matrix.length-1);
        if (r == -1 || r == matrix.length)
            return false;
        return searchCol(matrix, r, target, 0, matrix[0].length-1);
    }

    private int searchRow(int [][] matrix, int target, int start, int end) {
        if (start > end)
            return end;
        int mid = (start+end)/2;
        int val = matrix[mid][0];
        if (val == target)
            return mid;
        else if (val > target)
            return searchRow(matrix, target, start, mid-1);
        else
            return searchRow(matrix, target, mid+1, end);
    }

    private boolean searchCol(int [][] matrix, int row, int target, int start, int end) {
        if (start > end)
            return false;
        int mid = (start + end)/2;
        int val = matrix[row][mid];
        if (val == target)
            return true;
        else if (val > target)
            return searchCol(matrix, row, target, start, mid-1);
        else
            return searchCol(matrix, row, target, mid+1, end);
    }
}
