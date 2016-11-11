package leetcode.java8.ValidAnagram;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 5/31/16.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.merge(s.charAt(i), 1, (x, y) -> x + y);
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), -1, (x, y) -> x + y);
            if (map.get(t.charAt(i)) < 0)
                return false;
        }
        return true;
    }
}
