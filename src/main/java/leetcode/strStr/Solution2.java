package leetcode.strStr;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/29/14
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution2 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0)
            return 0;
        int[] T = new int[needle.length()+1];
        build(needle, T);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == needle.length())
                    return i- needle.length()+1;
            } else if (j != 0) {
                j = T[j];
                i--;
            }
        }
        return 0;
    }

    private void build(String needle, int[] T) {
        T[0] = 0;
        T[1] = 0;
        for (int i = 2; i < T.length; i++) {
            int j = T[i-1];
            while (true) {
                if (needle.charAt(i-1) == needle.charAt(j)) {
                    T[i] = T[i-1]+1;
                    break;
                } else if (j != 0) {
                    j = T[j];
                } else
                    break;
            }
        }
    }
}
