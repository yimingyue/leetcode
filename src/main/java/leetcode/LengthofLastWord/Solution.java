package leetcode.LengthofLastWord;

/**
 * Created by ymyue on 6/20/15.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int start = 0;
        int i = 0;
        int len = 0;
        while (i <= s.length()) {
            if (i == s.length() || s.charAt(i) == ' ') {
                len = i - start;
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                if (i == s.length())
                    return len;
                start = i;
            } else
                i++;
        }
        return len;
    }
}
