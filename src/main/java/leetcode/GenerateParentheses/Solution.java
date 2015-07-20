package leetcode.GenerateParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ymyue on 5/24/15.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> rList = new ArrayList<>();
        if (n <= 0)
            return rList;

        // how many left parenthesis are used in the string
        Map<String, Integer> map = new HashMap<> ();
        map.put("", 0);
        for (int i = 0; i < n * 2; i++) {
            Map<String, Integer> nMap = new HashMap<>();
            for (String str : map.keySet()) {
                int m = map.get(str);
                if (m < n) {
                    nMap.put(str + "(", m + 1);
                }
                if (i < 2 * m) {
                    nMap.put(str + ")", m);
                }
            }
            map = nMap;
        }
        rList.addAll(map.keySet());
        return rList;
    }
}
