package leetcode.WordBreakII;

import java.util.*;

/**
 * Created by ymyue on 10/21/16.
 */
public class Solution4 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return wordBreak(s, wordDict, map);
    }

    private List<String> wordBreak(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s))
            return map.get(s);
        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add(s);
            return result;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = wordBreak(s.substring(word.length()), wordDict, map);
                for (String str : subList)
                    result.add(word + (str.isEmpty() ? "" : " ") + str);
            }
        }
        map.put(s, result);
        return result;
    }
}
