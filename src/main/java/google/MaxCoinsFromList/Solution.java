package google.MaxCoinsFromList;

/**
 * Created by ymyue on 10/2/16.
 * Time complexity: O(n^2)
 * Space complexity: O(N^2)
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=180324&highlight=google
 * Round 1, Question 2
 */
public class Solution {
    public int maxValue(int[] arr) {
        int n = arr.length;
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                if (i == 0)
                    matrix[j][j+i] = arr[j];
                else if (i == 1)
                    matrix[j][j+i] = Math.max(arr[j], arr[j+i]);
                else {
                    matrix[j][j+i] = Math.max(arr[j] + Math.min(matrix[j+2][j+i], matrix[j+1][j+i-1]),
                            arr[j+i] + Math.min(matrix[j][j+i-2], matrix[j+1][j+i-1]));
                }
            }
        }
        return matrix[0][n-1];
    }
}
