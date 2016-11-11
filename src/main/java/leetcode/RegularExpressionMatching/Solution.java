package leetcode.RegularExpressionMatching;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/3/14
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        while (true) {
            if (i == s.length() && j == p.length())
                return true;
            if (j == p.length())
                return false;
            if (i == s.length()) {
                if (j == p.length()-1)
                    return false;
                if (p.charAt(j+1) == '*') {
                    j = j + 2;
                    continue;
                }
                else
                    return false;
            }
            if (p.charAt(j) == '.') {
                if (j == p.length()-1 || p.charAt(j+1) != '*') {
                    i++;
                    j++;
                } else {
                    if (j+2 == p.length())
                        return true;
                    p = p.substring(j+2);
                    for (int k = i; k <= s.length(); k++) {
                        if (isMatch(s.substring(k), p))
                            return true;
                    }
                    return false;
                }
            } else if (j < p.length()-1 && p.charAt(j+1) == '*') {
                char ch = p.charAt(j);
                if (j+2 == p.length()) {
                    while (i != s.length() && s.charAt(i) == ch)
                        i++;
                    return i == s.length();
                }
                j += 2;
                while (i != s.length() && s.charAt(i) == ch) {
                    if (isMatch(s.substring(i), p.substring(j)))
                        return true;
                    i++;
                }
            } else {
                if (p.charAt(j) != s.charAt(i))
                    return false;
                i++;
                j++;
            }
        }
    }
}
