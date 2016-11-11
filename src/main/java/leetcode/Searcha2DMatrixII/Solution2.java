package leetcode.Searcha2DMatrixII;

/**
 * Created by ymyue on 10/22/16.
 */
public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n-1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] < target)
                x++;
            else
                y--;
        }
        return false;
    }
}
