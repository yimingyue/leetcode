package leetcode.PalindromePartitioningII;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/4/14
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int minCut(String s) {
        int [] minCuts = new int[s.length()];
        boolean [][] p = new boolean[s.length()][s.length()];
        minCuts[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            int min = i-1;
            for (int j = 0; j < i; j++) {
                if (i-j < 2 || (s.charAt(j) == s.charAt(i) && p[j+1][i-1])) {
                    p[j][i] = true;
                    if (j == 0) {
                        min = 0;
                        break;
                    } else {
                        min = min > minCuts[j] + 1 ? minCuts[j] + 1 : min;
                    }
                }
            }
            minCuts[i] = min;
        }

        return minCuts[s.length()-1];
    }
}
