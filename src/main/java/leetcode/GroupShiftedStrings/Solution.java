package leetcode.GroupShiftedStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ymyue on 6/12/16.
 * Time complexity: O(nk)
 * Space complexity: O(n)
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String key = getKey(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<List<String>> (map.values());
    }

    private String getKey(String word) {
        StringBuilder sb = new StringBuilder();
        if (word.isEmpty())
            return sb.toString();
        char ch = word.charAt(0);
        for (int i = 0; i < word.length(); i++) {
            sb.append((word.charAt(i) + 26 - ch) % 26);
            sb.append(".");
        }
        return sb.toString();
    }
}
