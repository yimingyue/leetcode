package leetcode.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 6/22/16.
 * Time complexity: O(mn)
 * Space complexity: O(mn)
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int l = Math.min(m, n) / 2;
        for (int i = 0; i < l; i++) {
            for (int j = i; j < n-i; j++)
                list.add(matrix[i][j]);
            for (int j = i+1; j < m-i-1; j++)
                list.add(matrix[j][n-1-i]);
            for (int j = n-i-1; j >= i; j--)
                list.add(matrix[m-1-i][j]);
            for (int j = m-i-2; j >= i+1; j--)
                list.add(matrix[j][i]);
        }
        if (m < n) {
            if (m % 2 == 1) {
                for (int j = m/2; j < n-m/2; j++)
                    list.add(matrix[m/2][j]);
            }
        } else {
            if (n % 2 == 1) {
                for (int j = n/2; j < m-n/2; j++)
                    list.add(matrix[j][n/2]);
            }
        }
        return list;
    }
}
