package leetcode.WildcardMatching;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/23/14
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.isEmpty()) {
            if (p.isEmpty())
                return true;
            for (int k = 0; k < p.length(); k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if (p.isEmpty())
            return false;

        int i = 0;
        int j = 0;
        int startP = 0;
        int startS = 0;
        while (i < s.length()) {
            if (j == p.length() && startP != 0) {
                i = ++startS;
                j = startP;
            } else if (j == p.length())
                return false;
            else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else if (p.charAt(j) == '*') {
                while (j < p.length() && p.charAt(j) == '*')
                    j++;
                if (j == p.length())
                    return true;
                startP = j;
                startS = i;
            } else if (p.charAt(j) != s.charAt(i) && startP != 0) {
                i = ++startS;
                j = startP;
            } else
                return false;
        }

        while (j < p.length() && p.charAt(j) == '*')
            j++;
        if (j == p.length())
            return true;
        return false;
    }
}