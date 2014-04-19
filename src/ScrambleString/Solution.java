package ScrambleString;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/14/14
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;

        int m1 = 0;
        int m2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            m1 += s1.charAt(i) - '0';
            m2 += s2.charAt(i) - '0';
        }
        if (m1 != m2)
            return false;

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length()-i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length()-i)))
                return true;
        }
        return false;
    }
}