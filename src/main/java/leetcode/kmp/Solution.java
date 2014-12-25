package leetcode.kmp;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/5/14
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty())
            return haystack;
        int i = 0;
        int j = 0;
        int m = needle.length();
        int n = haystack.length();

        int [] F = buildFailureFunction(needle);
        while (true) {
            if (i == n)
                break;
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == m)
                    return haystack.substring(i-m);
            } else {
                if (j > 0)
                    j = F[j];
                else
                    i++;
            }
        }
        return null;
    }

    private int [] buildFailureFunction(String needle) {
        int [] F = new int [needle.length()+1];
        F[0] = 0;
        F[1] = 0;
        if (needle.length() < 2)
            return F;
        int m = 2;
        while (m <= needle.length()) {
            int j = F[m-1];
            while (true) {
                if (needle.charAt(j) == needle.charAt(m-1)) {
                    F[m] = j+1;
                    break;
                } else {
                    if (j == 0) {
                        F[m]  = 0;
                        break;
                    }
                    else {
                        j = F[j];
                    }
                }
            }
            m++;
        }
        return F;
    }
}
