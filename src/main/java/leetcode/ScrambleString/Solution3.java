package leetcode.ScrambleString;

import java.util.Arrays;

/**
 * Created by ymyue on 1/1/16.
 */
public class Solution3 {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 1)
            return s1.equals(s2);
        int n = s1.length();
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);
        if (!Arrays.equals(arr1, arr2))
            return false;
        for (int i = 1; i < s1.length(); i++) {
            if ((isScramble(String.valueOf(arr1, 0, i), String.valueOf(arr2, 0, i))
                    && isScramble(String.valueOf(arr1, i, n-i), String.valueOf(arr2, i, n-i)))
                    || (isScramble(String.valueOf(arr1, 0, i), String.valueOf(arr2, n-i, i))
                    && isScramble(String.valueOf(arr1, i, n-i), String.valueOf(arr2, 0, n-i))))
                return true;
        }
        return false;
    }
}
