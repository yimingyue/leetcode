package leetcode.WildcardMatching;

/**
 * Created by ymyue on 11/24/15.
 */
public class Solution2 {
    public boolean isMatch(String s, String p) {
        int m = 0;
        int n = 0;
        while (true) {
            int i = m;
            int j = n;
            while (true) {
                if (i == s.length() && j == p.length())
                    return true;
                if (i == s.length()) {
                    while (j < p.length() && p.charAt(j) == '*')
                        j++;
                    return j == p.length();
                }
                if (j == p.length() || (p.charAt(j) != '*' && p.charAt(j) != '?' && p.charAt(j) != s.charAt(i))) {
                    if (n > 0 && p.charAt(n-1) == '*') {
                        m++;
                        break;
                    }
                    return false;
                } else if (p.charAt(j) == '*') {
                    m = i;
                    n = j;
                    while (n < p.length() && p.charAt(n) == '*')
                        n++;
                    if (n == p.length())
                        return true;
                    break;
                } else {
                    i++;
                    j++;
                }
            }
        }
    }
}
