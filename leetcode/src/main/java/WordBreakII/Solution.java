package WordBreakII;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/29/14
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> list = new ArrayList<>();
        if (s.isEmpty()) {
            if (dict.contains(s)) {
                list.add(s);
            }
            return list;
        }

        boolean [] a = new boolean[s.length()+1];
        a[0] = true;
        Map<Integer, Set<Integer>> map = new HashMap<> ();


        for (int i = 1; i <= s.length(); i++) {
            Set set = new HashSet<Integer>();
            for (int j = 0; j < i; j++) {
                if (!a[j])
                    continue;
                String sub = s.substring(j, i);
                if (dict.contains(sub)) {
                    a[i] = true;
                    set.add(j);
                }
            }
            if (a[i])
                map.put(i, set);
        }

        if (a[s.length()])
            buildList(list, map, s.length(), "", s);
        return list;
    }

    void buildList(List<String> list, Map<Integer, Set<Integer>> map, int index, String suffix, String s) {
        Set<Integer> set = map.get(index);
        for (int value : set) {
            String sub = s.substring(value, index);
            if (!suffix.isEmpty())
                sub = sub + " " + suffix;
            if (value == 0) {
                list.add(sub);
            } else {
                buildList(list, map, value, sub, s);
            }
        }
    }
}
