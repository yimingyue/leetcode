package leetcode.RegularExpressionMatching;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution2 {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int i, String p, int j) {
        while (j < p.length()) {
            if (j+1 == p.length()) {
                if (i == s.length())
                    return false;
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    i++;
                    j++;
                } else
                    return false;
            } else if (p.charAt(j+1) == '*') {
                if (p.charAt(j) == '.') {
                    while (i <= s.length()) {
                        if (isMatch(s, i, p, j+2))
                            return true;
                        i++;
                    }
                    return false;
                } else {
                    while (i < s.length()) {
                        if (isMatch(s, i, p, j+2))
                            return true;
                        if (s.charAt(i) == p.charAt(j))
                            i++;
                        else
                            break;
                    }
                    if (isMatch(s, i, p, j+2))
                        return true;
                    return false;
                }
            }  else {
                if (i == s.length())
                    return false;
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    i++;
                    j++;
                } else
                    return false;
            }
        }
        return i == s.length();
    }
}
