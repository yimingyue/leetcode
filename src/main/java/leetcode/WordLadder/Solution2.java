package leetcode.WordLadder;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/6/14
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution2 {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end))
            return 1;
        Set<String> set = new HashSet<String> ();
        Set<String> fullSet = new HashSet<String> ();
        int i = 1;
        set.add(start);
        fullSet.add(start);
        while (!set.isEmpty()) {
            i++;
            Set<String> newSet = new HashSet<String> ();
            for (String s : set)
                newSet.addAll(generateStrs(s, dict, fullSet));
            if (newSet.contains(end))
                return i;
            set = newSet;
            fullSet.addAll(set);
        }
        return 0;
    }

    private Set<String> generateStrs(String s, Set<String> dict, Set<String> fullSet) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char[] arr = s.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                String str = new String(arr);
                if (dict.contains(str) && !fullSet.contains(str))
                    set.add(str);
            }
        }
        return set;
    }
}
