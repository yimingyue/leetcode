package leetcode.IsSubsequence;

/**
 * Created by ymyue on 9/17/16.
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            char chs = s.charAt(i);
            char cht = t.charAt(j);
            if (chs == cht)
                i++;
            j++;
        }
        return i == s.length();
    }
}
