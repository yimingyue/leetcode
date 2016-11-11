package leetcode.GeneralizedAbbreviation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 7/11/16.
 * Time complexity: O(2^n)
 * Space complexity: O(1)
 */
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        helper(result, word, 0, "", 0, false);
        return result;
    }

    private void helper(List<String> result, String word, int i, String abbr, int count, boolean endInNum) {
        if (i == word.length()) {
            result.add(abbr + (endInNum ? count : ""));
            return;
        }
        if (endInNum) {
            helper(result, word, i+1, abbr, count+1, true);
            helper(result, word, i+1, abbr + count + word.charAt(i), 0, false);
        } else {
            helper(result, word, i+1, abbr, 1, true);
            helper(result, word, i+1, abbr + word.charAt(i), 0, false);
        }
    }
}
