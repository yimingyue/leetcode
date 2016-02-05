package leetcode.ShortestPalindrome;

/**
 * Created by ymyue on 11/22/15.
 */
public class Solution2 {
    public String shortestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        int n = s.length();
        int[] T = new int[n/2+1];
        buildAutomation(s.substring(0, n/2), T);
        int j = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (i <= j) {
                return new StringBuilder(s.substring(i+j+1)).reverse().toString() + s;
            }
            while (true) {
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                    break;
                }
                if (j == 0)
                    break;
                j = T[j];
            }
        }
        return null;
    }

    private void buildAutomation(String s, int[] T) {
        T[0] = 0;
        T[1] = 0;
        for (int i = 2; i <= s.length(); i++) {
            int j = T[i-1];
            while (true) {
                if (s.charAt(j) == s.charAt(i-1)) {
                    T[i] = j+1;
                    break;
                }
                if (j == 0) {
                    T[j] = 0;
                    break;
                }
                j = T[j];
            }
        }
    }
}
