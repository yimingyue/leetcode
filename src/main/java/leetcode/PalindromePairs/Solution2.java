package leetcode.PalindromePairs;

import java.util.*;

/**
 * Created by ymyue on 10/22/16.
 */
public class Solution2 {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            map.put(words[i], i);
        List<List<Integer>> result = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                if (isPalindrome(word, 0, i)) {
                    String rev = reverse(word, i, word.length());
                    if (!rev.equals(word) && map.containsKey(rev))
                        result.add(Arrays.asList(map.get(rev), map.get(word)));
                }
            }
            for (int i = word.length()-1; i >= 0; i--) {
                if (isPalindrome(word, i, word.length())) {
                    String rev = reverse(word, 0, i);
                    if (map.containsKey(rev))
                        result.add(Arrays.asList(map.get(word), map.get(rev)));
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String word, int i, int j) {
        j--;
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--))
                return false;
        }
        return true;
    }

    private String reverse(String word, int i, int j) {
        StringBuilder sb = new StringBuilder();
        while (--j >= i)
            sb.append(word.charAt(j));
        return sb.toString();
    }
}
