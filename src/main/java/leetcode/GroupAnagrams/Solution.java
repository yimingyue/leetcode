package leetcode.GroupAnagrams;

import java.util.*;

/**
 * Created by ymyue on 6/7/16.
 * Beats 97% :-)
 * Time complexity O(mnlogm) - m is average length of a string
 * Space complexity O(mn)
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortedStr = getSorted(str);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            map.putIfAbsent(sortedStr, list);
        }
        return new ArrayList<List<String>> (map.values());
    }

    private String getSorted(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}
