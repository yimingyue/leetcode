package leetcode.Searcha2DMatrix;

/**
 * Created by ymyue on 6/26/16.
 */
public class Solution3 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            throw new IllegalArgumentException();
        return searchInRow(matrix, searchRow(matrix, target), target);
    }

    private int searchRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < matrix[mid][0])
                high = mid-1;
            else if (mid < high && target >= matrix[mid+1][0])
                low = mid+1;
            else
                return mid;
        }
        return low;
    }

    private boolean searchInRow(int[][] matrix, int row, int target) {
        int low = 0;
        int high = matrix[row].length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == matrix[row][mid])
                return true;
            else if (target < matrix[row][mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return false;
    }
}
