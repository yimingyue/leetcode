package leetcode.IsomorphicStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ymyue on 6/11/16.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char m = s.charAt(i);
            char p = t.charAt(i);
            if (!map.containsKey(m)) {
                if (!set.add(p))
                    return false;
                map.put(m, p);
            } else if (map.get(m) != p)
                return false;
        }
        return true;
    }
}
