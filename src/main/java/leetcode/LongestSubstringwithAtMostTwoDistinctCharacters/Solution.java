package leetcode.LongestSubstringwithAtMostTwoDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 6/12/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<> ();
        int i = 0;
        int j = 0;
        int count = 0;
        int maxLength = 0;
        while (i < s.length()) {
            Character ch = s.charAt(i++);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else {
                count++;
                map.put(ch, 1);
            }

            while (count > 2) {
                char c = s.charAt(j++);
                if (map.get(c) == 1) {
                    map.remove(c);
                    count--;
                } else {
                    map.put(c, map.get(c)-1);
                }
            }
            maxLength = Math.max(maxLength, i - j);
        }
        return maxLength;
    }
}
