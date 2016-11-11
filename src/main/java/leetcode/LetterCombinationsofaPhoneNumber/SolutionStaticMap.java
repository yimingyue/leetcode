package leetcode.LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ymyue on 7/10/16.
 */
public class SolutionStaticMap {
    private static final Map<Character, String> numToLetters = new HashMap<>();
    static {
        numToLetters.put('2', "abc");
        numToLetters.put('3', "def");
        numToLetters.put('4', "ghi");
        numToLetters.put('5', "jkl");
        numToLetters.put('6', "mno");
        numToLetters.put('7', "pqrs");
        numToLetters.put('8', "tuv");
        numToLetters.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty())
            return res;
        dfs(res, digits, 0, "");
        return res;
    }

    private void dfs(List<String> res, String digits, int i, String word) {
        if (i == digits.length()) {
            res.add(word);
            return;
        }
        for (char ch : numToLetters.getOrDefault(digits.charAt(i), "").toCharArray()) {
            dfs(res, digits, i+1, word+ch);
        }
    }
}
