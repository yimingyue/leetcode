package leetcode.RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ymyue on 6/11/16.
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= s.length(); i++) {
            String str = s.substring(i-10, i);
            if (!map.containsKey(str))
                map.put(str, 1);
            else if (map.get(str) == 1) {
                list.add(str);
                map.put(str, 2);
            }
        }
        return list;
    }
}
