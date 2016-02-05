package leetcode.strStr;

/**
 * Created by ymyue on 11/22/15.
 */
public class Solution3 {
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty())
            return 0;
        if (haystack.isEmpty())
            return -1;
        if (needle.isEmpty())
            return 0;
        int [] arr = new int[needle.length()+1];
        buildAutomation(needle, arr);

        int j = 0;
        for (int i = 0; i < haystack.length();) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            else if (j == 0) {
                i++;
            } else {
                j = arr[j];
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    private void buildAutomation(String needle, int[] T) {
        T[0] = 0;
        T[1] = 0;
        for (int i = 2; i <= needle.length(); i++) {
            int j = T[i-1];
            while (true) {
                if (needle.charAt(j) == needle.charAt(i-1)) {
                    T[i] = j+1;
                    break;
                }
                if (j == 0) {
                    T[i] = 0;
                    break;
                }
                j = T[j];
            }
        }
    }
}
