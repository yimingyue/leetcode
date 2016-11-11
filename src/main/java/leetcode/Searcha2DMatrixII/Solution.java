package leetcode.Searcha2DMatrixII;

/**
 * Created by ymyue on 6/26/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        return searchMatrix(matrix, 0, matrix.length-1, 0, matrix[0].length-1, target);
    }

    private boolean searchMatrix(int[][] matrix, int startRow, int endRow, int startCol, int endCol, int target) {
        if ((startRow > endRow) || (startCol > endCol))
            return false;
        int low = 0;
        int high = Math.min(endRow-startRow, endCol-startCol);
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (matrix[startRow+mid][startCol+mid] == target)
                return true;
            else if (matrix[startRow+mid][startCol+mid] < target)
                low = mid+1;
            else high = mid-1;
        }
        return searchMatrix(matrix, startRow, startRow+high, startCol+low, endCol, target)
                || searchMatrix(matrix, startRow+low, endRow, startCol, startCol + high, target);
    }
}
