package leetcode.Searcha2DMatrix;

/**
 * Created by ymyue on 6/26/16.
 * Time complexity: O(logMN)
 * Space complexity: O(1)
 */
public class Solution4 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid/n][mid%n] == target)
                return true;
            else if (matrix[mid/n][mid%n] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }
}
