package leetcode.MinimumUniqueWordAbbreviation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ymyue on 10/8/16.
 */
public class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        for (int len = 1; len <= target.length(); len++) {
            Set<String> set = new HashSet<>();
            for (String word : dictionary) {
                if (word.length() == target.length()) {
                    List<String> list = new ArrayList<>();
                    generateAbbreviation(list, word, 0, 0, "", len);
                    set.addAll(list);
                }
            }
            List<String> list = new ArrayList<>();
            generateAbbreviation(list, target, 0, 0, "", len);
            for (String abbr : list) {
                if (!set.contains(abbr))
                    return abbr;
            }
        }
        return null;
    }

    private void generateAbbreviation(List<String> list, String s, int i, int num, String abbr, int len) {
        if (len > s.length() - i || len < 0)
            return;
        if (i == s.length()) {
            if (len == 0)
                list.add(abbr + (num == 0 ? "" : num));
            return;
        }
        if (num == 0)
            generateAbbreviation(list, s, i+1, 1, abbr, len-1);
        else
            generateAbbreviation(list, s, i+1, num+1, abbr, len);
        generateAbbreviation(list, s, i+1, 0, abbr+(num == 0 ? "" : num)+s.charAt(i), len-1);
    }
}
