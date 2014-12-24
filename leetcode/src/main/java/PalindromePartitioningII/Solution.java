package PalindromePartitioningII;

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
            int min = i;
            for (int j = 0; j < i; j++) {
                p[j][i] = false;
                if (s.charAt(j) == s.charAt(i) && (i-j < 2 || p[j+1][i-1])) {
                    p[j][i] = true;
                    if (j == 0) {
                        min = 0;
                        break;
                    } else {
                        if (min > minCuts[j-1])
                            min = minCuts[j-1] + 1;
                    }
                }
            }
            minCuts[i] = Math.min(min, (minCuts[i-1]+1));
        }

        return minCuts[s.length()-1];
    }
}
