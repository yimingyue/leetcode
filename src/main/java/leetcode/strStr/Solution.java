package strStr;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/12/14
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0)
            return -1;

        int m = needle.length();
        int[] F = new int[m+1];
        buildAutomation(needle, F);
        int i = 0;
        int j = 0;
        while (true) {
            if (i == m)
                return j - m;
            if (j == haystack.length())
                return -1;
            if (haystack.charAt(j) == needle.charAt(i)) {
                i++;
                j++;
            } else if (i > 0) {
                i = F[i];
            } else {
                i = 0;
                j++;
            }
        }
    }

    private void buildAutomation(String needle, int[] F) {
        F[0] = 0;
        F[1] = 0;
        for (int i = 2; i <= needle.length(); i++) {
            while (true) {
                int j = F[i-1];
                if (needle.charAt(j) == needle.charAt(i-1)) {
                    F[i] = j+1;
                    break;
                }
                if (j == 0) {
                    F[i] = 0;
                    break;
                }
                j = F[j];
            }
        }

    }
}
