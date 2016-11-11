package leetcode.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 11/15/15.
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            map.put(c, i);
            maxLength = Math.max(maxLength, i - start);
        }
        return maxLength;
    }
}
