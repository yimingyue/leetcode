package leetcode.InterleavingString;

/**
 * Created by ymyue on 8/23/15.
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        boolean[][] matrix = new boolean[s1.length()+1][s2.length()+1];
        for (int i = 0; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                matrix[i][j] = true;
            }
        }
        return isInterleave(s1, 0, s2, 0, s3, matrix);
    }

    private boolean isInterleave(String s1, int i, String s2, int j, String s3, boolean[][] matrix) {
        if (!matrix[i][j])
            return false;
        if (i == s1.length()) {
            if (s2.substring(j).equals(s3.substring(i + j)))
                return true;
            else {
                matrix[i][j] = false;
                return false;
            }
        }
        if (j == s2.length()) {
            if (s1.substring(i).equals(s3.substring(i+j)))
                return true;
            else {
                matrix[i][j] = false;
                return false;
            }
        }

        if (s1.charAt(i) != s3.charAt(i+j) && s2.charAt(j) != s3.charAt(i+j)) {
            matrix[i][j] = false;
            return false;
        }
        if (s1.charAt(i) == s3.charAt(i + j) && isInterleave(s1, i + 1, s2, j, s3, matrix)) {
            return true;
        }
        if (s2.charAt(j) == s3.charAt(i + j) && isInterleave(s1, i, s2, j + 1, s3, matrix)) {
            return true;
        }
        matrix[i][j] = false;
        return false;
    }
}

/*
  mistakes:
  1. String.equals not equalsTo

 */
