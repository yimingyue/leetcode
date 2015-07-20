package leetcode.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ymyue on 6/21/15.
 */
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty())
            return "";
        Map<Character, Integer> map = new HashMap<> ();
        Map<Character, LinkedList<Integer>> mapList = new HashMap<> ();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.merge(ch, 1, Integer::sum);
            if (!mapList.containsKey(ch))
                mapList.put(ch, new LinkedList<Integer> ());
        }
        String str = "";
        int i = 0;
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mapList.containsKey(ch)) {
                mapList.get(ch).add(i);
                if (map.containsKey(ch)) {
                    if (mapList.get(ch).size() == map.get(ch)) {
                        map.remove(ch);
                    }
                } else {
                    mapList.get(ch).poll();
                }
            }
            if (map.isEmpty())
                break;
        }
        if (i < s.length()) {
            int start = s.length();
            for (LinkedList<Integer> list : mapList.values()) {
                start = Math.min(start, list.peek());
            }
            int len = i - start + 1;
            str = s.substring(start, i+1);
            i++;
            for (; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (mapList.containsKey(ch)) {
                    LinkedList<Integer> list = mapList.get(ch);
                    int index = list.poll();
                    list.add(i);
                    if (index == start) {
                        for (int j = index + 1; j <= i; j++) {
                            if (mapList.containsKey(s.charAt(j)) && j == mapList.get(s.charAt(j)).peek()) {
                                int l = i - j + 1;
                                if (l < len) {
                                    str = s.substring(j, i+1);
                                    len = l;
                                }
                                start = j;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return str;
    }
}
