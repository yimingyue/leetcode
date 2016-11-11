package leetcode.WordLadder;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/19/14
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Set<String> set = new HashSet<String> ();
        set.add(start);
        dict.add(end);
        int count = 1;
        while (!set.isEmpty()) {
            Set<String> t = convert(set, dict);
            set.clear();
            ++count;
            for (String str : t) {
                if (str.equals(end)) return count;
                dict.remove(str);
                set.add(str);
            }
        }
        return 0;
    }

    private Set<String> convert(Set<String> set, Set<String> dict) {
        Set<String> t = new HashSet<String> ();
        for (String s : set) {
            for (int i = 0; i < s.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == s.charAt(i)) continue;
                    String r = s.substring(0, i) + c + s.substring(i+1);
                    if (dict.contains(r))
                        t.add(r);
                }
            }
        }
        return t;
    }
}
