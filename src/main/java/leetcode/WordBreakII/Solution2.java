package leetcode.WordBreakII;

import java.util.*;
/**
 * Created by ymyue on 10/18/15.
 */
public class Solution2 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> rList = new ArrayList<> ();
        if (s == null || s.isEmpty())
            return rList;
        int n = s.length()+1;
        boolean[] reach = new boolean[n];
        reach[0] = true;
        Map<Integer, List<Integer>> map = new HashMap<> ();
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (!reach[j])
                    continue;
                String sub = s.substring(j, i);
                if (wordDict.contains(sub)) {
                    reach[i] = true;
                    if (map.containsKey(i)) {
                        map.get(i).add(j);
                    } else {
                        List<Integer> list = new ArrayList<> ();
                        list.add(j);
                        map.put(i, list);
                    }
                }
            }
        }
        if (reach[s.length()])
            buildList(rList, s, s.length(), "", map);
        return rList;
    }

    private void buildList(List<String> rList, String s, int i, String str, Map<Integer, List<Integer>> map) {
        for (int j : map.get(i)) {
            if (i == s.length())
                str = s.substring(j, i);
            else
                str = s.substring(j, i) + " " + str;
            if (i == 0)
                rList.add(str);
            else
                buildList(rList, s, j, str, map);
        }
    }
}
