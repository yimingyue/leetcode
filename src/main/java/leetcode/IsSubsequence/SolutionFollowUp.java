package leetcode.IsSubsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ymyue on 9/24/16.
 */
public class SolutionFollowUp {
    public boolean isSubsequence(String s, String t) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            lists.add(new ArrayList<Integer> ());
        for (int i = 0; i < t.length(); i++) {
            lists.get(t.charAt(i)-'a').add(i);
        }
        int pos = 0;
        for (char ch : s.toCharArray()) {
            int index = Collections.binarySearch(lists.get(ch - 'a'), pos);
            if (index >= 0)
                pos = lists.get(ch-'a').get(index) + 1;
            else {
                int insertionPoint = -index-1;
                if (insertionPoint == lists.get(ch-'a').size())
                    return false;
                pos = lists.get(ch-'a').get(insertionPoint) + 1;
            }
        }
        return true;
    }
}
