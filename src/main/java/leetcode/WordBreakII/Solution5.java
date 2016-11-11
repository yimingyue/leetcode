package leetcode.WordBreakII;

import java.util.*;

/**
 * Created by ymyue on 10/21/16.
 */
public class Solution5 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return wordBreak(s, wordDict, map);
    }

    private List<String> wordBreak(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s))
            return map.get(s);
        int len = s.length();
        List<String> result = new ArrayList<>();
        if (wordDict.contains(s))
            result.add(s);
        for (int i = 1; i < len; i++) {
            String cur = s.substring(i);
            if (wordDict.contains(cur)) {
                List<String> strs = wordBreak(s.substring(0, i), wordDict, map);
                for (String str : strs)
                    result.add(str + " " + cur);
            }
        }
        map.put(s, result);
        return result;
    }
}
