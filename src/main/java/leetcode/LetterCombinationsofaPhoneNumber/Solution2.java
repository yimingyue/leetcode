package leetcode.LetterCombinationsofaPhoneNumber;

import java.util.*;

/**
 * Created by ymyue on 10/21/16.
 */
public class Solution2 {
    String[] map = new String[] {
            "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("");
        for (char ch : digits.toCharArray()) {
            String str = map[ch-'0'];
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                for (char c : str.toCharArray()) {
                    queue.offer(s + c);
                }
            }
        }
        return new ArrayList<>(queue);
    }
}
