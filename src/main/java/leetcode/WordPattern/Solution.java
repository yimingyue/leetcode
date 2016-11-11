package leetcode.WordPattern;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 6/11/16.
 * Time complexity: O(n)
 * Space complexity: O(logn)
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length())
            return false;
        String[] match = new String[26];
        Set<String> set = new HashSet<>();
        Arrays.fill(match, "");
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (match[ch-'a'].isEmpty()) {
                match[ch-'a'] = strs[i];
                if (!set.add(strs[i]))
                    return false;
            }
            else if (!match[ch-'a'].equals(strs[i]))
                return false;
        }
        return true;
    }
}
