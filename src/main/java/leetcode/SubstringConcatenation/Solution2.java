package leetcode.SubstringConcatenation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ymyue on 5/25/15.
 */
public class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s.isEmpty())
            return list;
        if (words == null || words.length == 0)
            return list;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word))
                map.put(word, map.get(word)+1);
            else
                map.put(word, 1);
        }

        int len = words[0].length();
        for (int i = 0; i < len; i++) {
            Map<String, Integer> nMap = new HashMap<> ();
            for (int j = i, k = j + len; k <= s.length(); j += len, k += len) {
                String str = s.substring(j, k);
                if (nMap.containsKey(str)) {
                    nMap.put(str, nMap.get(str)+1);
                } else {
                    nMap.put(str, 1);
                }
                int lens = len * words.length;
                if (k - i > lens) {
                    int end = k - lens;
                    int start = end - len;
                    String subStr = s.substring(start, end);
                    int cnt = nMap.get(subStr);
                    if (cnt == 1)
                        nMap.remove(subStr);
                    else
                        nMap.put(subStr, cnt - 1);
                }
                if (nMap.equals(map))
                    list.add(k - len * words.length);
            }
        }
        return list;
    }
}
