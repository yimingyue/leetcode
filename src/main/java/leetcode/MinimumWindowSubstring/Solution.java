package leetcode.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 6/21/15.
 */
public class Solution {
    public String minWindow(String s, String t) {
        if (t == null || t.isEmpty()) return t;
        Map<Character, Integer> map = new HashMap<> ();
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch)-1);
            else {
                count++;
                map.put(ch, -1);
            }
        }

        int i = 0;
        int j = 0;
        String r = null;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int cnt = map.get(ch)+1;
                map.put(ch, cnt);
                if (cnt == 0)
                    count--;
                if (count == 0) {
                    while (j <= i) {
                        char ch1 = s.charAt(j);
                        if (map.containsKey(ch1)) {
                            int cnt1 = map.get(ch1);
                            if (cnt1 == 0) {
                                if (r == null || i - j + 1 < r.length()) {
                                    r = s.substring(j, i+1);
                                }
                                break;
                            } else {
                                map.put(ch1, cnt1-1);
                            }
                        }
                        j++;
                    }
                }
            }
            i++;
        }
        return r == null ? "" : r;
    }
}
