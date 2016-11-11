package leetcode.MinimalWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 6/11/16.
 * Time complexity: O(m+n)
 * Space complexity: O(n)
 */
public class Solution2 {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty())
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            map.merge(t.charAt(i), 1, Integer::sum);
        int start = 0; int end = 0;
        int minimal = s.length()+1;
        int i = 0;
        int j = 0;
        int count = map.size();
        while (i < s.length()) {
            if (count > 0) {
                Character c = s.charAt(i);
                i++;
                if (map.containsKey(c)) {
                    map.put(c, map.get(c)-1);
                    if (map.get(c) == 0)
                        count--;
                }
            }
            while (count == 0) {
                if (i - j < minimal) {
                    minimal = i - j;
                    start = j;
                    end = i;
                }
                Character c = s.charAt(j);
                j++;
                if (map.containsKey(c)) {
                    if (map.get(c) == 0)
                        count++;
                    map.put(c, map.get(c)+1);
                }
            }
        }
        return s.substring(start, end);
    }
}
