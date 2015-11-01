package leetcode.IsomorphicStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ymyue on 11/1/15.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if (map.containsKey(chs)) {
                if (cht != map.get(chs))
                    return false;
            } else {
                if (set.contains(cht))
                    return false;
                map.put(chs, cht);
                set.add(cht);
            }
        }
        return true;
    }
}
