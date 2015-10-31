package leetcode.ScrambleString;

import java.util.Arrays;

/**
 * Created by ymyue on 7/19/15.
 */
public class Solution2 {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);
        if (!String.valueOf(c1).equals(String.valueOf(c2)))
            return false;
        if (s1.length() <= 3)
            return true;
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length()-i)) &&
                    isScramble(s1.substring(i), s2.substring(0, s2.length()-i)))
                return true;
        }
        return false;
    }
}
