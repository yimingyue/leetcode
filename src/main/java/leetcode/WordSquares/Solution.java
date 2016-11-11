package leetcode.WordSquares;



import java.util.*;

/**
 * Created by ymyue on 10/18/16.
 */
public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words.length == 0)
            return result;
        int n = words[0].length();
        helper(result, words, n, new ArrayList<> (), "");
        return result;
    }

    private void helper(List<List<String>> result, String[] words, int n, List<String> list, String prefix) {
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            if (cur.startsWith(prefix)) {
                list.add(cur);
                if (list.size() == n) {
                    result.add(new ArrayList<>(list));
                } else {
                    String next = "";
                    for (int j = 0; j < list.size(); j++)
                        next += list.get(j).charAt(list.size());
                    helper(result, words, n, list, next);
                }
                list.remove(list.size() - 1);
            }
        }
    }
}
